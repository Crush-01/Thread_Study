package t2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Test02 implements Runnable {
    ReentrantLock lock;
    public void setLock(ReentrantLock lock){
        this.lock=lock;
    }
    @Override
    public void run() {
        try {
            lock.lockInterruptibly();
            System.out.println(Thread.currentThread().getName()+"start");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+"end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(lock.tryLock()){
                lock.unlock();
            }

        }
    }
}
