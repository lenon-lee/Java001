package week04;

import java.util.concurrent.*;

public class Homework0304 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        // 异步执行 下面方法
        // 4. Thread + FutureTask + Callable + join()
        ComputeThread task4 = new ComputeThread();
        FutureTask<Integer> futureTask4 = new FutureTask<>(task4);
        Thread thread = new Thread(futureTask4);
        try {
            thread.start();
            thread.join();
            int result = futureTask4.get();

            // 确保  拿到result 并输出
            System.out.println("4 : Thread + FutureTask + Callable + join()异步计算结果为："+result);
            System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
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

