package chapter02.E_the_get_and_put_principle;
// ch02_4_3
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class Snippet_3 {
	public static double sum(Collection<? extends Number> nums) {
	   return nums.stream().mapToDouble(Number::doubleValue).sum();
	}
	public static void main(String[] args)  {
		List<Integer> ints = new ArrayList<>();
		ints.add(1);
		ints.add(2);
		List<? extends Number> nums = ints;
		double dbl = sum(nums);     // ok
		nums.add(3.14);             // compile-time error
	}
}