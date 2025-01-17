package chapter01.C_primitive_and_reference_types;
// ch01_1_6
import java.util.List;

public class Snippet_6 {
	public static Integer sumInteger(List<Integer> ints) {
	  Integer s = 0;
	  for (Integer n : ints) { s += n; }
	  return s;
	}
}