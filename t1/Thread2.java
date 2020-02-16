package t1;

public class Thread2 extends Thread{
    private Test t;
    Thread2(Test t){
        this.t=t;
    }

    @Override
    public void run(){
        t.method2();
    }

}
