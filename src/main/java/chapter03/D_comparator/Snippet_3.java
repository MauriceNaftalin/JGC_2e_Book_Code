package chapter03.D_comparator;
// ch03_4_4
import java.util.Comparator;

public class Snippet_3 {
	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
	  return new Comparator<>(){
	    public int compare(T o1, T o2) { return o1.compareTo(o2); }
	  };
	}
}