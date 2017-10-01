package com.michjony.basic.thinkingjava.j5things2;

import java.util.Collection;
import java.util.Comparator;

public interface SortedCollection<E> extends Collection<E> {
	public Comparator<E> getComparator();
	public void setComparator(Comparator<E> cmp);
}
