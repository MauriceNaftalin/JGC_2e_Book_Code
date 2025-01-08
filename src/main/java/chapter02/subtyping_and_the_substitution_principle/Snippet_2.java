package chapter02.subtyping_and_the_substitution_principle;
// ch02_1_3
import java.util.ArrayList;
import java.util.List;

public class Snippet_2 {
	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<>();
		List<Number> nums = ints;         //  can't be allowed 
		nums.add(3.14);
	}
}