package chapter07.E_use_generic_helper_methods_to_capture_wildcard;
// ch08_5_3
import java.util.List;
import java.util.ArrayList;

public class Snippet_3 {
	public static void reverse(List<?> list) { rev(list); }
	private static <T> void rev(List<T> list) {
	  List<T> tmp = new ArrayList<>(list);
	  for (int i = 0; i < list.size(); i++) {
	    list.set(i, tmp.get(list.size()-i-1));
	  }
	}
}