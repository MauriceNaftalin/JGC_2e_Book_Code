package chapter09.A_iterable_and_iterators;
// 11_1_4
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Snippet_3 {
	public static void main(String[] args)  {
		List<String> strings = new ArrayList<>(List.of("alpha", "bravo", "charlie"));
		List<String> modifiedStrings = strings.stream()
		    .filter(s -> s.contains("r"))
		    .toList();
		assert modifiedStrings.equals(List.of("bravo", "charlie"));

	}
}