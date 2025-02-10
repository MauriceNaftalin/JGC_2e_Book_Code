package org.jgcbook.chapter05.B_instance_tests_and_casts;
// ch06_2_4
import java.util.AbstractCollection;
import java.util.ListIterator;
import java.util.List;
import java.util.Objects;

abstract class AbstractList_1<E> extends AbstractCollection<E> implements List<E> {
  public boolean equals(Object o) {
      if (!(o instanceof List<E>)) { return false; }      // compile-time error
      ListIterator<E> it1 = listIterator();
      ListIterator<E> it2 = ((List<E>)o).listIterator();  // unchecked cast
      while (it1.hasNext() && it2.hasNext()) {
          E e1 = it1.next();
          E e2 = it2.next();
          if (! Objects.equals(e1, e2))
              return false;
      }
      return !(it1.hasNext() || it2.hasNext());
  }
  // ...

}