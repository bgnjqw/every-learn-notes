/**
 * Created by john on 3/13/15.
 */
public class _2_RunnableTest implements Runnable {

    String name;

    public _2_RunnableTest(String name){
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("this is thread runnable test " + this.name);
        }
    }

    public static void main(String[] args){
        _2_RunnableTest r1 = new _2_RunnableTest("thread1");
        _2_RunnableTest r2 = new _2_RunnableTest("thread2");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();
    }
}
