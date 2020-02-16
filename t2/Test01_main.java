package t2;

import java.util.concurrent.locks.ReentrantLock;

public class Test01_main implements Runnable{
    private static ReentrantLock lock=new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        Test01_main t1=new Test01_main();
        Test02 t2=new Test02();
        t2.setLock(lock);
        Thread thread1=new Thread(t1,"t1");
        Thread thread2=new Thread(t2,"t2");
        thread1.start();
//        Thread.sleep(1000);
        thread2.start();
        thread2.interrupt();//t2线程被打断等待过程，并抛出java.lang.InterruptedException错误

    }
    public void run(){
        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName()+"start");
            for(int i=1;i<=100;i++){
                Thread.sleep(1000);
                System.out.println(i);
            }
            System.out.println(Thread.currentThread().getName()+"end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(lock.tryLock())
            lock.unlock();
        }
    }
}
