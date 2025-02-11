package org.jgcbook.chapter05.B_instance_tests_and_casts;
// ch06_2_3
import java.util.Collection;
import java.util.List;

public class Program_3 {
	// compiles in Java 16 onwards
	public static <T> List<T> asList(Collection<T> cl) {
	    return cl instanceof List<T> q ? q : cl.stream().toList();
	}
}