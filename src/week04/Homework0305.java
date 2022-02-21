package week04;

import java.util.concurrent.*;

public class Homework0305 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        // 异步执行 下面方法
        // 5. CompletableFuture.get() + Callable
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CompletableFuture<Integer> cfSum = CompletableFuture.supplyAsync(()-> {
            int result =  sum();
            countDownLatch.countDown();
            return result;
        });
        try {
            int result = cfSum.get();
            cfSum.complete(100);
            System.out.println("5 : CompletableFuture.get() + Callable异步计算结果为："+result);
            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
            countDownLatch.await();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
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
