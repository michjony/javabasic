package com.michjony.basic.thinkingjava.generics;

import java.util.List;
import java.util.Random;

/**
 * 持有特定类型对象的列表，每次调用其上的select()方法时,可以随机的选取一个元素
 *
 * @author Michael-jony
 * @since 2017年12月16日 下午7:41:01
 */
public class RandomList<T> {

    private List<T> storage;

    private Random rand = new Random(47);

    public RandomList(List<T> list) {
        storage = list;
    }

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }
}
