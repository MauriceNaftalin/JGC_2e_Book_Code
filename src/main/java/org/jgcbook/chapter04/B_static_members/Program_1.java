package org.jgcbook.chapter04.B_static_members;
// ch04_1_3
import java.util.List;
import java.util.Arrays;

public class Program_1 {
	public static void main(String[] args)  {
		List<Integer> ints = Arrays.asList(1, 2, 3);
		List<String> strings = Arrays.asList("one","two");
		assert ints.getClass() == strings.getClass();

	}
}