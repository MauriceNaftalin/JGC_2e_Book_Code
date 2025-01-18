package chapter02.E_the_get_and_put_principle;
// ch02_4_6
import java.util.List;

public class Snippet_6 {
	public static void main(String[] args)  {
		List<Object> objs = List.of(1,"two");
		List<? super Integer> ints = objs;
		String str = "";
		for (Object obj : ints) str += obj.toString();
		assert str.equals("1two");
	}
}