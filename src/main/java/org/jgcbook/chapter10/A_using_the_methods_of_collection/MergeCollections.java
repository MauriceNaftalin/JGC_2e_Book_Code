package org.jgcbook.chapter10.A_using_the_methods_of_collection;
// 12a17
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class MergeCollections {
    static <T extends Comparable<? super T>> List<T> merge
            (Collection<? extends T> c1, Collection<? extends T> c2) {
        List<T> mergedList = new ArrayList<T>();
        Iterator<? extends T> itr1 = c1.iterator();
        Iterator<? extends T> itr2 = c2.iterator();
        T c1Element = getNextElement(itr1);
        T c2Element = getNextElement(itr2);
        // each iteration will take a task from one of the iterators;
        // continue until neither iterator has any further tasks
        while (c1Element != null || c2Element != null) {
            // use the current c1 element if either the current c2
            // element is null, or both are non-null and the c1 element
            // precedes the c2 element in the natural order
            boolean useC1Element = c2Element == null ||
                    c1Element != null && c1Element.compareTo(c2Element) < 0;
            if (useC1Element) {
                mergedList.add(c1Element);
                c1Element = getNextElement(itr1);
            } else {
                mergedList.add(c2Element);
                c2Element = getNextElement(itr2);
            }
        }
        return mergedList;
    }
    static <E> E getNextElement(Iterator<E> itr) {
        if (itr.hasNext()){
            E nextElement = itr.next();
            if (nextElement == null) throw new NullPointerException();
            return nextElement;
        } else {
            return null;
        }
    }

}