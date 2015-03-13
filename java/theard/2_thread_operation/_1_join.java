import com.sun.javafx.font.t2k.T2KFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by john on 3/14/15.
 */
public class _1_join implements Runnable{

    String name;

    public _1_join(String name){
        this.name = name;
    }

    @Override
    public void run() {
        int a = 1;
        while(a < 11){
            System.out.println("this is thread " + this.name + " " + a);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a++;
        }
    }


    public static void main(String[] args) throws InterruptedException {

        _1_join r1 = new _1_join("THREAD1");
        _1_join r2 = new _1_join("THREAD2");
        _1_join r3 = new _1_join("THREAD3");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t3.start();
        t3.join();

        t2.start();
        t2.join();

        t1.start();
        t1.join();

        System.out.println("this is the end");
    }
}
