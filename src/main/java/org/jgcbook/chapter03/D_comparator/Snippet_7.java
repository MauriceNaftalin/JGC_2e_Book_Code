package org.jgcbook.chapter03.D_comparator;
// ch03_4_8
import java.util.Comparator;
import java.util.List;

public class Snippet_7 {
	public static <E>
	  Comparator<List<E>> listComparator(final Comparator<? super E> comp) {
	  return new Comparator<>() {
	    public int compare(List<E> list1, List<E> list2) {
	      int n1 = list1.size();
	      int n2 = list2.size();
	      for (int i = 0; i < Math.min(n1, n2); i++) {
	        int k = comp.compare(list1.get(i), list2.get(i));
	        if (k != 0) return k;
	      }
	      return Integer.compare(n1, n2);
	    }
	  };
	}
}