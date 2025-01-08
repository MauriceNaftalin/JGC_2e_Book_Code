package chapter02.the_get_and_put_principle;
// ch02_4_1
import java.util.Collection;

public class Snippet_1 {
	public static double sum(Collection<? extends Number> nums) {
	  double s = 0.0;
	  for (Number num : nums) s += num.doubleValue();
	  return s;
	}
}