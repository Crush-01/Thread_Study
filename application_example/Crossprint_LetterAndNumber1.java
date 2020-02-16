package application_example;

import java.util.concurrent.locks.LockSupport;
//字母数字交替打印
public class Crossprint_LetterAndNumber1 {
    static int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static char[] letter = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'}; //字母
    static Thread t1;
    static Thread t2;

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i:number) {
                System.out.println(i);
                LockSupport.park();
                LockSupport.unpark(t2);
            }

        });
        t2 = new Thread(() -> {

            for (char c:letter) {
                System.out.println(c);
                LockSupport.unpark(t1);
                LockSupport.park();

            }

        });
        t1.start();
        t2.start();
    }

}
