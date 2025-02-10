package org.jgcbook.chapter02.I_restrictions_on_wildcards;
// ch02_8_4
import java.util.List;
import java.util.ArrayList;

public class Snippet_4 {
	public static void main(String[] args)  {
		List<?> list1 = new ArrayList<Object>();   // ok
		List<?> list2 = new List<Object>(); // compile-time error
		List<?> list3 = new ArrayList<?>(); // compile-time error

	}
}