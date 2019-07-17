package com.michjony.basic.util.threadfactory;

import com.michjony.basic.thinkingjava.generics.RandomList;

import java.util.List;

/**
 * user:Cherie
 * datetime;2019/7/16 8:30
 */
public class MyTask<T> implements Runnable {

    private List<T> list;

    public MyTask(List<T> list) {
        this.list = list;
    }

    @Override
    public void run() {
        RandomList<T> randomList = new RandomList<T>(list);
        T select = randomList.select();
        System.out.println("this task  is : " + String.valueOf(select));
    }
}
