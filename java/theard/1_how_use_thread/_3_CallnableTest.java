import com.sun.org.apache.xalan.internal.utils.FeatureManager;

import java.util.concurrent.*;

/**
 * Created by john on 3/13/15.
 */
public class _3_CallnableTest implements Callable<String> {

    String name;

    public _3_CallnableTest(String name){
        this.name = name;
    }

    @Override
    public String call() throws InterruptedException {
        int a = 1;
        while(a < 100){
            System.out.println("this is thread runnable test " + a + "  " + this.name);
            a++;
            TimeUnit.SECONDS.sleep(1);
        }
        return this.name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        _3_CallnableTest r1 = new _3_CallnableTest("thread1");
        _3_CallnableTest r2 = new _3_CallnableTest("thread2");

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<String> f1 = executor.submit(r1);
        Future<String> f2 = executor.submit(r2);

//        f1.cancel(true);

//        System.out.println(f1.get());
//        System.out.println(f2.get());
        System.out.println("this is the end");

        executor.shutdownNow();


    }
}
