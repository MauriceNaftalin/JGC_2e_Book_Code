package chapter09.A_iterable_and_iterators;
// 11_1_3
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Snippet_2 {
	public static void main(String[] args)  {
		List<String> strings = new ArrayList<>(List.of("alpha", "bravo", "charlie"));
		for (Iterator<String> itr = strings.iterator() ; itr.hasNext() ; ) {
		    String s = itr.next();
		    if (! s.contains("r")) {
		        itr.remove();
		    }
		}
		assert strings.equals(List.of("bravo", "charlie"));

	}
}