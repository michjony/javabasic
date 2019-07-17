package com.michjony.basic.util.threadfactory;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * user:Cherie
 * datetime;2019/7/16 8:14
 */
public class MyThreadPool {

    public static final LinkedBlockingQueue<Runnable> queues = new LinkedBlockingQueue<>();

    public static final String source = "This is a simple thread pool";

    public void threadpool() {
        int coresize = Runtime.getRuntime().availableProcessors();
        MyThreadFactory factory = new MyThreadFactory("testpool", true, 1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coresize, coresize, 30L, TimeUnit.SECONDS, queues);

        // produces
        for (int i = 0; i < 2000; i++) {
            threadPoolExecutor.execute(new MyTask(Arrays.asList(source.toCharArray())));
        }
        for (; ; ) {
            BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
            System.out.println("size:" + queue.size());
            if (queue.size() == 0) {
                System.out.println("task is over");
                threadPoolExecutor.shutdown();
                System.exit(0);
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) {
        new MyThreadPool().threadpool();
    }

}
