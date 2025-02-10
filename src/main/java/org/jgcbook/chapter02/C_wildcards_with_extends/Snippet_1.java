package org.jgcbook.chapter02.C_wildcards_with_extends;
// ch02_2_1x
import java.util.List;
import java.util.ArrayList;

public class Snippet_1 {
	public static void main(String[] args)  {
		List<Number> nums = new ArrayList<>();
		List<Integer> ints = List.of(1, 2);
		List<Double> dbls = List.of(1.0, 0.5);
		nums.addAll(ints);
		nums.addAll(dbls);
		assert nums.equals(List.of(1, 2, 1.0, 0.5));

	}
}