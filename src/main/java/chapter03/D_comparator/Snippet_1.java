package chapter03.D_comparator;
// ch03_4_1
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Snippet_1 {
	public static void main(String[] args)  {
		Comparator<String> sizeOrder =
		  new Comparator<>() {
			  public int compare(String s1, String s2) {
				  if (s1.length() < s2.length())
					  return -1;
				  if (s1.length() > s2.length())
					  return 1;
				  return s1.compareTo(s2);
			  }
		  };
		assert "two".compareTo("three") > 0;
		assert sizeOrder.compare("two", "three") < 0;
		Collection<String> strings = Arrays.asList("from","aaa","to","zzz");
		assert Collections.max(strings).equals("zzz");
		assert Collections.min(strings).equals("aaa");
		assert Collections.max(strings, sizeOrder).equals("from");
		assert Collections.min(strings, sizeOrder).equals("to");
	}
}