package chapter02.wildcards_versus_type_parameters;
// ch02_6_3
import java.util.Collection;

interface MyCollection<E> {  // alternative design
  public boolean contains(E o);
  public boolean containsAll(Collection<? extends E> c);

}