package org.jgcbook.chapter03.A_comparable;
// ch03_1_4

public class Snippet_3 {
	public static void main(String[] args)  {
		Integer i = 0;
		String s = "one";
		assert i.compareTo(s) < 0; // compile-time error

	}
}