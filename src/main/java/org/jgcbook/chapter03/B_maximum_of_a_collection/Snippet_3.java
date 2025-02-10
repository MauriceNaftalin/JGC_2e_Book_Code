package org.jgcbook.chapter03.B_maximum_of_a_collection;
// ch03_2_3
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Snippet_3 {
	public static void main(String[] args)  {
		List<Integer> ints = Arrays.asList(0, 1, 2);
		assert Collections.max(ints) == 2;
		List<String> strs = Arrays.asList("zero", "one", "two");
		assert Collections.max(strs).equals("zero");

	}
}