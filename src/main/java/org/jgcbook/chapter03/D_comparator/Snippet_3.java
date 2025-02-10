package org.jgcbook.chapter03.D_comparator;
// ch03_4_4
import java.util.Comparator;

public class Snippet_3 {
	public static <T extends Comparable<? super T>> Comparator<T>  naturalOrder() {
	  return (o1, o2) -> o1.compareTo(o2);
	}
}