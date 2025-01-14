package chapter02.D_the_get_and_put_principle;
// ch02_4_2
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Snippet_2 {
	public static double sum(Collection<? extends Number> nums) {
	   return nums.stream().mapToDouble(Number::doubleValue).sum();
	}
	public static void storeIntegers(Collection<? super Integer> ints, int n) {
	  for (int i = 0; i < n; i++) ints.add(i);
	}
	public static double sumValues(Collection<Number> nums, int n) {
	  storeIntegers(nums, n);
	  return sum(nums);
	}
	public static void main(String[] args)  {
		List<Integer> ints = List.of(1,2,3);
		assert sum(ints) == 6.0;
		List<Double> doubles = List.of(2.5,3.5);
		assert sum(doubles) == 6.0;
		List<Number> nums = List.of(1,2,2.5,3.5);
		assert sum(nums) == 9.0;
		List<Integer> ints1 = new ArrayList<>();
		storeIntegers(ints1, 5);
		assert ints1.equals(List.of(0, 1, 2, 3, 4));
		List<Number> nums1 = new ArrayList<>();
		storeIntegers(nums1, 5); nums1.add(5.0);
		assert nums1.equals(List.of(0, 1, 2, 3, 4, 5.0));
		List<Object> objs1 = new ArrayList<>();
		storeIntegers(objs1, 5); objs1.add("five");
		assert objs1.equals(List.of(0, 1, 2, 3, 4, "five"));
		List<Number> nums2 = new ArrayList<>();
		double sum = sumValues(nums2, 5);
		assert sum == 10;
	}
}