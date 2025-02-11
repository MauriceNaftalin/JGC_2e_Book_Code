package org.jgcbook.chapter07.E_use_generic_helper_methods_to_capture_wildcard;
// ch08_5_2
import java.util.List;
import java.util.ArrayList;

public class Program_2 {
	public static <T> void reverse(List<T> list) {
	  List <T> tmp = new ArrayList<>(list);
	  for (int i = 0; i < list.size(); i++) {
	    list.set(i, tmp.get(list.size()-i-1));
	  }
	}
}