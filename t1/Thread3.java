package t1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread3 extends Thread{
    private Test t;
    ExecutorService service=Executors.newWorkStealingPool(4);
    Thread3(Test t){
        this.t=t;
    }

    @Override
    public void run(){
        try {
            t.method3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
