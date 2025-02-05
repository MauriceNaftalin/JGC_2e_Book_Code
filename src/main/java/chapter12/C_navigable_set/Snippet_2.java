package chapter12.C_navigable_set;
// 13c7
import java.util.NavigableSet;
import java.util.Collections;
import java.util.Optional;
import java.util.TreeSet;

public class Snippet_2 {
	public static void main(String[] args)  {
		NavigableSet<String> stringSet = new TreeSet<>();
		Collections.addAll(stringSet, "abc", "cde", "x-ray" ,"zed");
		Optional<String> last = Optional.ofNullable(stringSet.floor("x-ray"));
		assert last.equals(Optional.of("x-ray"));
		Optional<String> secondToLast = last.map(stringSet::lower);
		assert secondToLast.equals(Optional.of("cde"));
		Optional<String> thirdToLast = secondToLast.map(stringSet::lower);
		assert thirdToLast.equals(Optional.of("abc"));

	}
}