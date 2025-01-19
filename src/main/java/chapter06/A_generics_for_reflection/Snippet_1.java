package chapter06.A_generics_for_reflection;
// ch07_1_1

public class Snippet_1 {
	public static void main(String[] args)  {
		Class<Integer> ki = Integer.class;
		Number n = Integer.valueOf(42);
		Class<? extends Number> kn = n.getClass();
		assert ki == kn;
	}
}