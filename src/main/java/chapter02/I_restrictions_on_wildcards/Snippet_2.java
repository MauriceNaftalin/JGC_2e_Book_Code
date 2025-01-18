package chapter02.I_restrictions_on_wildcards;
// ch02_8_2
import java.util.List;
import java.util.ArrayList;

public class Snippet_2 {
	public static void main(String[] args)  {
		List<Number> nums = new ArrayList<Number>();
		List<? super Number> sink = nums;
		List<? extends Number> source = nums;
		for (int i=0; i<4; i++) sink.add(i);
		int sum = nums.stream().mapToInt(Number::intValue).sum();
		assert sum == 6;
	}
}