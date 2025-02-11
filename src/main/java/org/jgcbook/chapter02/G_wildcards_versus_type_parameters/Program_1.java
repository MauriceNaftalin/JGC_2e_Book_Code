package org.jgcbook.chapter02.G_wildcards_versus_type_parameters;
// ch02_6_1
import java.util.List;

public class Program_1 {
	public static void main(String[] args)  {
		Object obj = "one";
		List<Object> objs = List.of("one", 2, 3.5, 4);
		List<Integer> ints = List.of(2, 4);
		assert objs.contains(obj);
		assert objs.containsAll(ints);
		assert ! ints.contains(obj);
		assert ! ints.containsAll(objs);

	}
}