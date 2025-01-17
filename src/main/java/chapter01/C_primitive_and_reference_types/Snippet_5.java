package chapter01.C_primitive_and_reference_types;
// ch01_1_5
import java.util.List;

public class Snippet_5 {
	public static int sum (List<Integer> ints) {
	  int s = 0;
	  for (int n : ints) { s += n; }
	  return s;
	}
}