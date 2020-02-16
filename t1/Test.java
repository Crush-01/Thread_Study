package t1;

public class Test {
    public synchronized void method1() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("1111");
    }

    public void method2(){
        System.out.println("22222");
    }
    public synchronized void method3() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("33333");
    }

}
