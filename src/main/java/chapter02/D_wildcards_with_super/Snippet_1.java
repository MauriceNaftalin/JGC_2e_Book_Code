package chapter02.D_wildcards_with_super;
// ch02_3_1
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Collections;

public class Snippet_1 {
	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
	  for (int i = 0; i < src.size(); i++) {
	    dest.set(i, src.get(i));
	  }
	}
	public static void main(String[] args)  {
		List<Object> objs = Stream.of(2, 3.14, "four").collect(Collectors.toList());
		List<Integer> ints = List.of(5, 6);
		Collections.copy(objs, ints);
		assert objs.equals(List.of(5, 6, "four"));
		Collections.copy(objs, ints);
		Collections.<Object>copy(objs, ints);
		Collections.<Number>copy(objs, ints);
		Collections.<Integer>copy(objs, ints);
	}
}