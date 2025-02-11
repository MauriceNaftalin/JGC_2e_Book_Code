package org.jgcbook.chapter06.B_reflected_types_are_reifiable_types;
// ch07_1_4
import java.util.ArrayList;
import java.util.List;

public class Program_1 {
	public static void main(String[] args)  {
		List<Integer> ints = new ArrayList<Integer>();
		List<String> strs = new ArrayList<String>();
		assert ints.getClass() == strs.getClass();
		assert ints.getClass() == ArrayList.class;

	}
}