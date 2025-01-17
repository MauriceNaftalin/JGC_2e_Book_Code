package chapter05.B_instance_tests_and_casts;
// ch06_2_2
import java.util.Collection;
import java.util.List;

public class Snippet_2 {
	// compiles in Java 16 onwards
	public static <T> List<T> asList(Collection<T> cl) {
	    return cl instanceof List<T> ? (List<T>)cl : cl.stream().toList();
	}
}