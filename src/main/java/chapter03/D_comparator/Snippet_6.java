package chapter03.D_comparator;
// ch03_4_7
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Snippet_6 {
	public static void main(String[] args)  {
		record Person(String name, int age) {}
		Comparator<Person> compareByName = Comparator.comparing(Person::name);
		Person a32 = new Person("Alice", 32);
		Person b23 = new Person("Bob", 23);
		List<Person> l = new ArrayList<>(List.of(a32, b23));
		l.sort(compareByName);
		assert l.equals(List.of(a32,b23));
		Comparator<Person> compareByAge = Comparator.comparingInt(Person::age);
		l.sort(compareByAge);
		assert l.equals(List.of(b23,a32));
		l.sort(compareByAge.reversed());
		assert l.equals(List.of(a32,b23));
		Person a23 = new Person("Alice", 23);
		l.add(a23);
		l.sort(compareByName.thenComparing(compareByAge));
		assert l.equals(List.of(a23,a32,b23));
		l.sort(compareByAge.reversed().thenComparing(compareByName.reversed()));
		assert l.equals(List.of(a32,b23,a23));
		l.add(null);
		l.sort(Comparator.nullsFirst(compareByAge));
		assert l.equals(Arrays.asList(null,b23,a23,a32));
	}
}