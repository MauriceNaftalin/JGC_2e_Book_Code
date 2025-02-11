package org.jgcbook.chapter03.B_maximum_of_a_collection;
// ch03_2_1
import java.util.Collection;
import java.util.Iterator;

public class Program_1 {
	public static <T extends Comparable<T>> T max(Collection<T> coll) { 
	    Iterator<? extends T> i = coll.iterator();
	    T candidate = i.next();
	    while (i.hasNext()) {
	        T next = i.next();
	        if (next.compareTo(candidate) > 0)
	            candidate = next;
	    }
	    return candidate;
	} 
}