package chapter05.J_array_creation_and_varargs;
// ch06_10_1
import java.util.List;

class Varargs {
    static <T> T[] createGenericArray(T... args) {
        return args;
    }

	public static void main(String[] args)  {
		List<Integer>[] intLists = Varargs.createGenericArray(List.of(1));
		List<? extends Number>[] numLists = intLists;
		numLists[0] = List.of(3.14);        // heap pollution
		int n = intLists[0].get(0);         // class cast exception

	}
}