package org.jgcbook.chapter03.C_a_fruity_example.example_3_2;
// ch03_3_2
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

abstract class Fruit implements Comparable<Fruit> {
  protected String name;
  protected int size;
  protected Fruit(String name, int size) {
    this.name = Objects.requireNonNull(name);
    this.size = size;
  }
  public boolean equals(Object o) {
    if (o == null) return false;
    if (o instanceof Fruit that) {
      return this.name.equals(that.name) && this.size == that.size;
    } else return false;
  }
  public int hashCode() {
    return Objects.hash(name, size);
  }
  public int compareTo(Fruit that) {
    return Integer.compare(this.size, that.size);
  }
}
class Apple extends Fruit {
  public Apple(int size) { super("Apple", size); }
}
class Orange extends Fruit {
  public Orange(int size) { super("Orange", size); }
}
class Test {
  public static void main(String[] args) {
    Apple a1 = new Apple(1); Apple a2 = new Apple(2);
    Orange o3 = new Orange(3); Orange o4 = new Orange(4);
    List<Apple> apples = Arrays.asList(a1, a2);
    assert Collections.max(apples).equals(a2);
    List<Orange> oranges = Arrays.asList(o3, o4);
    assert Collections.max(oranges).equals(o4);
    List<Fruit> mixed = List.of(a1, o3);
    assert Collections.max(mixed).equals(o3); // ok
  }

}