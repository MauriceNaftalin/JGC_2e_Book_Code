package org.jgcbook.chapter03.D_comparator;
// ch03_4_5
import java.util.Collections;
import java.util.Collection;
import java.util.Comparator;

public class Snippet_4 {
	public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
	  return Collections.max(coll, Comparator.naturalOrder());
	}
}