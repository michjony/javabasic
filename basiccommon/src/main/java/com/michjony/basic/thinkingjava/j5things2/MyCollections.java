package com.michjony.basic.thinkingjava.j5things2;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MyCollections<E> implements SortedCollection<E> {
	
	public static <T> List<T> reverse(List<T> src) {
		List<T> results = new ArrayList<>(src);
		Collections.reverse(results);
		return results;
	}

	private Comparator<E> comparator;
	private ArrayList<E> list;
	public MyCollections(Comparator<E> c){
		this.list = new ArrayList<>();
		this.comparator = c;
	}
	public MyCollections(Collection<? extends E> src ,Comparator<E> c){
		this.list = new ArrayList<E>(src);
		this.comparator = c;
		sortThis();
	}
	private void sortThis() {
		Collections.sort(list, comparator);
	}
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public boolean contains(Object o) {
		return list.contains(o);
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator(); 
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return list.toArray(a);
	}

	@Override
	public boolean add(E e) {
		boolean r = list.add(e);
		sortThis();
		return r;
	}

	@Override
	public boolean remove(Object o) {
		boolean r = list.remove(o);
		sortThis();
		return r;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean r = list.addAll(c);
		sortThis();
		return r;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean r = list.removeAll(c);
		sortThis();
		return r;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean r = list.retainAll(c);
		sortThis();
		return r;
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public int hashCode() {
		return list.hashCode();
	}
	@Override
	public boolean equals(Object o) {
		if(o == this){
			return true;
		}
		if(o instanceof MyCollections){
			MyCollections<E> a = (MyCollections<E>)o;
			return this.list.equals(a.list);
		}
		return false;
	}
	@Override
	public Comparator<E> getComparator() {
		return comparator;
	}

	@Override
	public void setComparator(Comparator<E> cmp) {
		this.comparator = cmp;
	}
}
