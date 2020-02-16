package application_example;

public class Crossprint_LetterAndNumber3 {
    static int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static char[] letter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'}; //字母

    public static void main(String[] args) {
        Object o=new Object();
        new Thread(() -> {
            synchronized (o){
                for(int i:number){
                    System.out.println(i);
                    try {
                        o.wait();
                        System.out.println("wait");
                        o.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (o){
                for(char c:letter){
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
