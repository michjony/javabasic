package com.michjony.basic.thinkingjava.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.michjony.basic.thinkingjava.generics.coffee.Coffee;
import com.michjony.basic.thinkingjava.generics.coffee.CoffeeGenerator;
import com.michjony.basic.util.Generator;

public class Generators {

    /**
     * 根据生产器gen生成集合
     *
     * @param coll
     * @param gen
     * @param size
     * @return
     */
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int size) {
        for (int i = 0; i < size; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static <T> List<T> fill(List<T> l, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            l.add(gen.next());
        }
        return l;
    }

    public static <T> Queue<T> fill(Queue<T> q, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            q.add(gen.next());
        }
        return q;
    }

    public static <T> Set<T> fill(Set<T> s, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            s.add(gen.next());
        }
        return s;
    }

    public static <T> LinkedList<T> fill(LinkedList<T> ll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            ll.add(gen.next());
        }
        return ll;
    }

    public static void main(String[] args) {

        Generator<Coffee> gen = new CoffeeGenerator();
        int size = 6;
        Collection<Coffee> coffees = fill(new ArrayList<Coffee>(), gen, size);
        for (Coffee coffee : coffees) {
            System.out.println(coffee);
        }

        Generator<Integer> fibgen = new Fibonacci();
        Collection<Integer> fnumers = fill(new ArrayList<Integer>(), fibgen, size);
        for (Integer i : fnumers) {
            System.out.println(i);
        }
    }
}
