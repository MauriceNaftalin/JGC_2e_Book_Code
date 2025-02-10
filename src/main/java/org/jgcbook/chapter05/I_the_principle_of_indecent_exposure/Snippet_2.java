package org.jgcbook.chapter05.I_the_principle_of_indecent_exposure;
// ch06_9_2
import java.util.List;

public class Snippet_2 {
	public static void main(String[] args)  {
		List[] intListArray = { List.of(0) };
		List<Integer>[] intLists = (List<Integer>[])intListArray;  // unchecked cast
		List<? extends Number>[] numLists = intLists;
		numLists[0] = List.of(3.14);
		int n = intLists[0].get(0);  // class cast exception!

	}
}