package chapter01.B_generic_methods_and_varargs;
// ch01_1_X
import java.util.List;
import java.util.ArrayList;

class Lists_1 {
  public static <T> List<T> toList(T[] arr) {
    List<T> list = new ArrayList<T>();
    for (T elt : arr) list.add(elt);
    return list;
  }

	public static void main(String[] args)  {
		List<Integer> ints = Lists_1.toList(new Integer[] {1, 2, 3});
		List<String> words = Lists_1.toList(new String[] { "Hello", "world!" });
	}
}