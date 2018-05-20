import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by nitinkumarsharma on 2/26/17.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(20,20,1, TimeUnit.DAYS, new ArrayBlockingQueue(50));

        List<Future<String>> futureList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            futureList.add(executor.submit(new myCallable(String.valueOf(i))));
        }

        int count =1;
        for (Future<String> stringFuture : futureList) {
            try {
                if(count%2==0){
                    stringFuture.cancel(true);
                }
                String val = stringFuture.get();
                System.out.println(val);
            }catch (ExecutionException e){
                System.out.println("ExecutionException");
            }catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }

        /*try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        executor.shutdown();

    }
}

class myCallable implements Callable<String>{

    myCallable(String a){
        this.init = a;
    }

    private String init;

    @Override
    public String call() throws InterruptedException, CustomException {
        if (Integer.parseInt(this.init)%2==0){
            Thread.sleep(5000);
            throw new CustomException();
        }
        return this.init;
    }
}