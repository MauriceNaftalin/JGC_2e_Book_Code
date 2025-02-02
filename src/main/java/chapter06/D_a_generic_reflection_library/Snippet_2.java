package chapter06.D_a_generic_reflection_library;
// ch07_4_3
import java.util.Collection;

public class Snippet_2 {
	public static <T> T[] toArray(Collection<T> c, T[] a) {
	  if (a.length < c.size()) a = GenericReflection.newArray(a, c.size());
	  int i=0; for (T x : c) a[i++] = x;
	  if (i < a.length) a[i] = null;
	  return a;
	}
}