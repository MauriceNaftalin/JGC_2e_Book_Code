package chapter03.C_a_fruity_example.example_3_1;
// ch03_3_1
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

abstract class Fruit {
  protected String name;
  protected int size;
  protected Fruit(String name, int size) {
    this.name = name; this.size = size;
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
  protected int compareTo(Fruit that) {
    return Integer.compare(this.size, that.size);
  }
}
class Apple extends Fruit implements Comparable<Apple> {
  public Apple(int size) { super("Apple", size); }
  public int compareTo(Apple a) { return super.compareTo(a); }
}
class Orange extends Fruit implements Comparable<Orange> {
  public Orange(int size) { super("Orange", size); }
  public int compareTo(Orange o) { return super.compareTo(o); }
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
    Collections.max(mixed);       // compile-time error
  }

}