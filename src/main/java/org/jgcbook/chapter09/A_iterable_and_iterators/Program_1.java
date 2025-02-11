package org.jgcbook.chapter09.A_iterable_and_iterators;
// 11_1_2
import java.util.List;
import java.util.ArrayList;

public class Program_1 {
	public static void main(String[] args)  {
		List<String> strings = new ArrayList<>(List.of("alpha", "bravo", "charlie"));
		for (String s : strings) {
		    if (! s.contains("r")) {
		        strings.remove(s);      // throws ConcurrentModificationException
		    }
		}

	}
}