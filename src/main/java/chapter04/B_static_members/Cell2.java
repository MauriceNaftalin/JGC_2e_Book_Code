package chapter04.B_static_members;
// ch04_1_5
import java.util.List;
import java.util.ArrayList;

class Cell2<T> {
  private final T value;
  private static List<T> values = new ArrayList<T>(); // illegal
  public Cell2(T value) {
        this.value=value;
        values.add(value);
  }
  public T getValue() { return value; }
  public static List<T> getValues() { return values; } // illegal

}