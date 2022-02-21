package week04;

import java.util.concurrent.CompletableFuture;


public class Homework0306 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        // 异步执行 下面方法
        // 6. CompletableFuture.join() + Callable
        CompletableFuture<Integer> cfSum6 = CompletableFuture.supplyAsync(Homework0306::sum);
        int result = cfSum6.join();
        System.out.println("6 : CompletableFuture.join() + Callable异步计算结果为："+result);
        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        // 然后退出main线程
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
