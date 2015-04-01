/**
 * Created by john on 3/13/15.
 */
public class _1_ThreadTest extends Thread{

    String name;

    public _1_ThreadTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("this is a thread test " + this.name);
        }
    }

    public static void main(String[] args){
        _1_ThreadTest t1 = new _1_ThreadTest("thread1");
        _1_ThreadTest t2 = new _1_ThreadTest("thread2");
        t1.start();
        t2.start();

        t1.stop();
    }

}
