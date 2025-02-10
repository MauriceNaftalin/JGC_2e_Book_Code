package org.jgcbook.chapter10.A_using_the_methods_of_collection;
// 12a19
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.ArrayList;

public class Snippet_17 {
	<T> List<T> merge(Collection<? extends T> c1, Collection<? extends T> c2) {
	    return Stream.of(c1, c2)
	        .flatMap(Collection::stream)
	        .sorted()
	        .collect(Collectors.toCollection(ArrayList::new));
	}
}