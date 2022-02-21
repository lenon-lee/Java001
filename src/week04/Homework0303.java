package week04;

import java.lang.reflect.Method;
import java.util.concurrent.*;

public class Homework0303 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池
        // 异步执行 下面方法
        // 3. Thread + Future + Callable
        ComputeThread task3 = new ComputeThread();
        FutureTask<Integer> futureTask3 = new FutureTask<>(task3);
        new Thread(futureTask3).start();
        try {
            int result = futureTask3.get();

            // 确保  拿到result 并输出
            System.out.println("3 : Thread + FutureTask + Callable异步计算结果为：" + result);
            System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
        } catch (InterruptedException  | ExecutionException e) {
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
class ComputeThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Method method1 = Homework0304.class.getDeclaredMethod("sum");
        method1.setAccessible(true);
        return (Integer)method1.invoke(null);
    }
}
