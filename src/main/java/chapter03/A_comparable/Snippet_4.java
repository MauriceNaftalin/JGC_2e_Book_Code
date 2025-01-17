package chapter03.A_comparable;
// ch03_1_5

public class Snippet_4 {
	public static void main(String[] args)  {
		Number m = Integer.valueOf(2);
		Number n = Double.valueOf(3.14);
		assert m.compareTo(n) < 0; // compile-time error
	}
}