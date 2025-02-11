package org.jgcbook.chapter12.C_navigable_set;
// 13c8
import java.util.NavigableSet;
import java.util.Collections;
import java.util.Optional;
import java.util.TreeSet;

public class Program_8 {
	public static void main(String[] args)  {
		NavigableSet<String> stringSet = new TreeSet<>();
		Collections.addAll(stringSet, "abc", "cde", "x-ray" ,"zed");
		Optional<String> last = Optional.ofNullable(stringSet.floor("x-ray"));
		assert last.equals(Optional.of("x-ray"));
		Optional<String> secondToLast = last.map(stringSet::lower);
		assert secondToLast.equals(Optional.of("cde"));
		Optional<String> thirdToLast = secondToLast.map(stringSet::lower);
		assert thirdToLast.equals(Optional.of("abc"));

		NavigableSet<String> headSet = stringSet.headSet(last.get(), true);
		NavigableSet<String> reverseHeadSet = headSet.descendingSet();
		assert reverseHeadSet.toString().equals("[x-ray, cde, abc]");
		String conc = " ";
		for (String s : reverseHeadSet) {
		  conc += s + " ";
		}
		assert conc.equals(" x-ray cde abc ");

	}
}