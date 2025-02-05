package chapter04.B_static_members;
// ch04_1_6
import java.util.List;
import java.util.ArrayList;

class Cell3<T> {
  private final T value;
  private static List<Object> values = new ArrayList<Object>(); // ok
  public Cell3(T value) {
        this.value=value;
        values.add(value);
  }
  public T getValue() { return value; }
  public static List<Object> getValues() { return values; } // ok

	public static void main(String[] args)  {
		Cell3<String> a = new Cell3<String>("one");
		Cell3<Integer> b = new Cell3<Integer>(2);
		assert Cell3.getValues().equals(List.of("one", 2));

	}
}