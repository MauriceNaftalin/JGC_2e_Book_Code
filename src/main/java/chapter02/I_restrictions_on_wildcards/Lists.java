package chapter02.I_restrictions_on_wildcards;
// ch02_8_5
import java.util.List;
import java.util.ArrayList;

class Lists {
  public static <T> List<T> factory() { return new ArrayList<T>(); }

	public static void main(String[] args)  {
		List<?> list = Lists.factory();
		List<?> list = Lists.<Object>factory();
		List<?> list = Lists.<?>factory();  // compile-time error
		List<List<?>> list = Lists.<List<?>>factory();  // ok
	}
}