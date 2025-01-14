package chapter02.D_the_get_and_put_principle;
// ch02_4_4
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Snippet_4 {
	public static double sum(Collection<? extends Number> nums) {
	   return nums.stream().mapToDouble(Number::doubleValue).sum();
	}
	public static void main(String[] args)  {
		List<Object> objs = new ArrayList<>();
		objs.add(1);
		objs.add("two");
		List<? super Integer> ints = objs;
		ints.add(3);             // ok
		double dbl = sum(ints);  // compile-time error
	}
}