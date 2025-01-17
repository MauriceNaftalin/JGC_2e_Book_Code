package chapter01.B_generic_methods_and_varargs;
// ch01_1_Y
import java.util.List;
import java.util.ArrayList;

class Lists_2 {
  public static <T> List<T> toList(T... arr) {
    List<T> list = new ArrayList<T>();
    for (T elt : arr) list.add(elt);
    return list;
  }

	public static <T> void addAll(List<T> list, T... arr) {
	  for (T elt : arr) list.add(elt);
	}
	public static void main(String[] args)  {
		List<Integer> ints1 = Lists_2.toList(1, 2, 3);
		List<String> words = Lists_2.toList("Hello", "world!");
		var ints = Lists_2.<Integer>toList();
		var objs = Lists_2.<Object>toList(1, "two");
	}
}