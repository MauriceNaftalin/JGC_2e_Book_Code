package chapter05.B_instance_tests_and_casts;
// ch06_2_1
import java.util.ArrayList;
import java.util.List;

public class Snippet_1 {
	public static void main(String[] args)  {
		// compiles in Java 16 onwards
		ArrayList<Integer> x = new ArrayList<>();
		assert x instanceof List<? extends Number>;
	}
}