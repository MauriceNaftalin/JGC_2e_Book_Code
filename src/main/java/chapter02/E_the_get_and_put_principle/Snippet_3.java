package chapter02.E_the_get_and_put_principle;
// ch02_4_2a
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Snippet_3 {
	public static void storeIntegers(Collection<? super Integer> ints, int n) {
	  for (int i = 0; i < n; i++) ints.add(i);
	}
	public static void main(String[] args)  {
		List<Integer> ints1 = new ArrayList<>();
		storeIntegers(ints1, 5);
		assert ints1.equals(List.of(0, 1, 2, 3, 4));
		List<Number> nums1 = new ArrayList<>();
		storeIntegers(nums1, 5);
		nums1.add(5.0);
		assert nums1.equals(List.of(0, 1, 2, 3, 4, 5.0));
		List<Object> objs1 = new ArrayList<>();
		storeIntegers(objs1, 5); objs1.add("five");
		assert objs1.equals(List.of(0, 1, 2, 3, 4, "five"));

	}
}