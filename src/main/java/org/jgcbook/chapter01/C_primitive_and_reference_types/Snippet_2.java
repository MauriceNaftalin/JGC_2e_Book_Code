package org.jgcbook.chapter01.C_primitive_and_reference_types;
// ch01_1_2
import java.util.ArrayList;
import java.util.List;

public class Snippet_2 {
	public static void main(String[] args)  {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(Integer.valueOf(1));
		int n = ints.get(0).intValue();

	}
}