package com.michjony.basic.util.threadfactory;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * user:Cherie
 * datetime;2019/7/16 8:24
 */
public class MyThreadFactory implements ThreadFactory {

    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;
    private final boolean daemon;
    private final int threadPriority;

    public MyThreadFactory(String namePrefix, boolean daemon, int priority) {
        SecurityManager s = System.getSecurityManager();
        this.group = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = namePrefix;
        this.daemon = daemon;
        this.threadPriority = priority;
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread();
        t.setDaemon(this.daemon);
        t.setPriority(this.threadPriority);
        t.setContextClassLoader(this.getClass().getClassLoader());
        t.setName("mypoolthread");
        return t;
    }
}
