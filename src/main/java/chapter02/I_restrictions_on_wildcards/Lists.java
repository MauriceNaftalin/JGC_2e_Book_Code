package chapter02.I_restrictions_on_wildcards;
// ch02_8_5
import java.util.List;
import java.util.ArrayList;

class Lists {
  public static <T> List<T> factory() { return new ArrayList<T>(); }

	public static void main(String[] args)  {
		List<?> list1 = Lists.factory();
		List<?> list2 = Lists.<Object>factory();

		List<?> list3 = Lists.<?>factory();  // compile-time error

		List<List<?>> list4 = Lists.<List<?>>factory();  // ok

	}
}