package chapter03.B_maximum_of_a_collection;
// ch03_2_4
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Snippet_4 {
	public static void main(String[] args)  {
		List<Number> nums = Arrays.asList(0, 1, 2, 3.14);
		assert Collections.max(nums) == 3.14; // compile-time error

	}
}