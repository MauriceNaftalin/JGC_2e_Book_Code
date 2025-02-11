package org.jgcbook.chapter17.G_customize_collections_using_the_abstract_classes;
// 19g1
import java.util.RandomAccess;
import java.util.AbstractList;
import java.util.List;
import java.util.ArrayList;

public class ListWithFixedFirstElement<E> extends AbstractList<E>
         implements RandomAccess {
    private final List<E> backingList;
    public ListWithFixedFirstElement(E fixedElement) {
        this.backingList = new ArrayList<>();
        backingList.add(fixedElement);
    }
    @Override
    public E set(int index, E element) {
        if (index != 0) {
            return backingList.set(index, element);
        } else {
            throw new IllegalArgumentException("Cannot change fixed first element");
        }
    }
    @Override
    public void add(int index, E element) {
        if (index != 0) {
            backingList.add(index, element);
        } else {
            throw new IllegalArgumentException("Cannot change fixed first element");
        }
    }
    @Override
    public E remove(int index) {
        if (index != 0) {
            return backingList.remove(index);
        } else {
            throw new IllegalArgumentException("Cannot change fixed first element");
        }
    }
    @Override
    public E get(int index) {
        return backingList.get(index);
    }
    @Override
    public int size() {
        return backingList.size();
    }

}