package org.jgcbook.chapter02.H_wildcard_capture;
// ch02_7_2
import java.util.ArrayList;
import java.util.List;

public class Program_1 {
	public static void reverse(List<?> list) {
	  List<Object> tmp = new ArrayList<>(list);
	  for (int i = 0; i < list.size(); i++) {
	    list.set(i, tmp.get(list.size()-i-1));  // compile-time error
	  }
	}
}