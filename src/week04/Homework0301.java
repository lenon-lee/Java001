package week04;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Homework0301 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池
        ExecutorService service = Executors.newCachedThreadPool();
        // 异步执行 下面方法
        // 1. FutureTask
        FutureTask<Integer> futureTask = new FutureTask(Homework0301::sum);
        service.submit(futureTask);
        try {
            int result = futureTask.get();
            System.out.println("1 : FutureTask异步计算结果为：" + result);
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // 关闭cached线程池, 以便结束JVM进程, 否则需要60秒空闲才能没有线程
            service.shutdown();
        }
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
