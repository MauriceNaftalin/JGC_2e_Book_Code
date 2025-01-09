package chapter03.maximum_of_a_collection;
// ch03_2_2
import java.util.Optional;
import java.util.Collection;
import java.util.Comparator;

public class Snippet_2 {
	public static <T extends Comparable<T>> Optional<T> max(Collection<T> coll) {
	    return coll.stream().max(Comparator.naturalOrder());
	}
}