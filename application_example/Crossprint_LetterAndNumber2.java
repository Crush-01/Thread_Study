package application_example;

public class Crossprint_LetterAndNumber2 {
    static int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static char[] letter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'}; //字母
    enum ReadyToRun {T1,T2}  //泛型
    static volatile ReadyToRun r=ReadyToRun.T1;

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i:number) {
                while(r!=ReadyToRun.T1){
//                    System.out.println("111");
                }
                System.out.println(i);
                r=ReadyToRun.T2;
            }
        }).start();
        new Thread(() -> {
            for (char c:letter) {
                while(r!=ReadyToRun.T2){
//                    System.out.println("222");
                }
                System.out.println(c);
                r=ReadyToRun.T1;
            }

        }).start();
    }

}
