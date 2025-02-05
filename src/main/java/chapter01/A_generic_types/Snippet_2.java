package chapter01.A_generic_types;
// ch01_0_2
import java.util.List;
import java.util.ArrayList;

public class Snippet_2 {
	public static void main(String[] args)  {
		List words = new ArrayList();
		words.add("Hello ");
		words.add("world!");
		String s = ((String)words.get(0))+((String)words.get(1));
		assert s.equals("Hello world!");

	}
}