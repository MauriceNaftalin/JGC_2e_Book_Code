package chapter09.G_lambdas_and_streams;
// 11.7.2
import java.util.List;
import java.util.Arrays;
import java.util.OptionalDouble;

public class Snippet_2 {
	public static void main(String[] args)  {
		Point origin = new Point(0, 0);
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		OptionalDouble maxDistance =
		   intList.stream()
		      .map(i -> new Point(i % 3, i / 3))
		      .mapToDouble(p -> p.distanceFrom(origin))
		      .max();

	}
}