package org.jgcbook.chapter02.C_wildcards_with_extends;
// ch02_2_2
import java.util.List;
import java.util.ArrayList;

public class Snippet_2 {
	public static void main(String[] args)  {
		List<Integer> ints = new ArrayList<>();
		List<? extends Number> nums = ints;  //  now legal 
		nums.add(3.14);                      //  can't be allowed

	}
}