package chapter02.A_subtyping_and_the_substitution_principle;
// ch02_1_4
import java.util.List;
import java.util.ArrayList;

public class Snippet_3 {
	public static void main(String[] args)  {
		List<Number> nums = new ArrayList<>();
		nums.add(3.14);
		List<Integer> ints = nums;        //  can't be allowed 
	}
}