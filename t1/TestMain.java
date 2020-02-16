package t1;

public class TestMain {//测试同步方法在执行时（不释放锁），非同步方法也可以执行
    public static void main(String[] args) {
        Test t=new Test();
        ThreadLocal a=new ThreadLocal();
        Thread1 thread1=new Thread1(t);
        Thread2 thread2=new Thread2(t);
        Thread3 thread3=new Thread3(t);
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
