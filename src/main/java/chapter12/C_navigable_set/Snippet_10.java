package chapter12.C_navigable_set;
// 13c10
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Snippet_10 {
	public static void main(String[] args)  {
		// construct and populate a NavigableSet whose iterator returns its
		// elements in the reverse of natural order:
		NavigableSet<String> base = new TreeSet<>(Comparator.reverseOrder());
		Collections.addAll(base, "b", "a", "c");
		// call the two different constructors for TreeSet, supplying the
		// set just constructed, but with different static types:
		NavigableSet<String> sortedSet1 = new TreeSet<>((Set<String>)base);
		NavigableSet<String> sortedSet2 = new TreeSet<>(base);
		// and the two sets have different iteration orders:
		List<String> forward = new ArrayList<>(sortedSet1);
		List<String> backward = new ArrayList<>(sortedSet2);
		assert !forward.equals(backward);
		assert forward.reversed().equals(backward);

	}
}