package t1;

public class Thread1 extends Thread{
    private Test t;
    Thread1(Test t){
        this.t=t;
    }

    @Override
    public void run(){
        try {
            t.method1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
