package chapter09.C_views;
// 11.3.1
import java.util.Arrays;

public class Snippet_1 {
	public static void main(String[] args)  {
		Integer[] arr = {1,2,3};
		var list = Arrays.asList(arr);
		list.set(0,3);
		assert arr[0] == 3;
		arr[2] = 0;
		assert list.get(2) == 0;
	}
}