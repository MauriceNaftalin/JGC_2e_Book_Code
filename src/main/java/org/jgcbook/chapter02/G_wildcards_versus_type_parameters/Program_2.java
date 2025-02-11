package org.jgcbook.chapter02.G_wildcards_versus_type_parameters;
// ch02_6_2
import java.util.List;

public class Program_2 {
	public static void main(String[] args)  {
		Object obj = 1;
		List<Object> objs = List.of(1, 3);
		List<Integer> ints = List.of(1, 2, 3, 4);
		assert ints.contains(obj);
		assert ints.containsAll(objs);

	}
}