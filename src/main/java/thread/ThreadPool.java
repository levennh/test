package thread;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(1);
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);   //工作队列

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                3,
                10,
                TimeUnit.SECONDS,
                queue,
                r -> new Thread(r, "myThread" + count.getAndIncrement()),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        threadPool.execute(() -> System.out.println("runnable"));

        Future<Object> submit = threadPool.submit(Math::random);

        Thread.sleep(1000);
        interrupt();
    }

    private static void interrupt() throws InterruptedException {
        Thread t = new Thread(() -> {
            synchronized (ThreadPool.class) {
                try {
                    ThreadPool.class.wait();
                } catch (Exception e) {
                    System.out.println(LocalDateTime.now() + "interrupted");
                    e.printStackTrace();
                }
            }
        }, "thread");
        t.start();

        Thread.sleep(1000);

        t.interrupt();
    }
}