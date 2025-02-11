package org.jgcbook.chapter02.F_arrays;
// ch02_5_2
import java.util.Arrays;
import java.util.List;

public class Program_2 {
	public static void main(String[] args)  {
		List<Integer> ints = Arrays.asList(0);
		List<Number> nums = ints;  // compile-time error
		nums.set(0, 3.14);

	}
}