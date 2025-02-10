package org.jgcbook.chapter02.E_the_get_and_put_principle;
// ch02_4_5
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snippet_7 {
	public static void main(String[] args)  {
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(2);
		List<? extends Number> nums = ints;
		nums.add(null);    // ok
		assert nums.equals(Arrays.asList(1, 2, null));

	}
}