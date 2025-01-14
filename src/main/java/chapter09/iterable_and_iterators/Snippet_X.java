package chapter09.iterable_and_iterators;
// bleahh
import java.util.List;
import java.util.ArrayList;

public class Snippet_X {
	public static void main(String[] args)  {
		List<String> strings = new ArrayList<>(List.of("alpha", "bravo", "charlie"));
		for (String s : strings) {
		    if (! s.contains("r")) {
		        strings.remove(s);
		    }
		}
	}
}