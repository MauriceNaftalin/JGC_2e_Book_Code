package chapter02.F_wildcards_versus_type_parameters;
// ch02_6_2a
import java.util.Collection;

interface MyCollection<E> {  // alternative design
	public boolean contains(E o);

	public boolean containsAll(Collection<? extends E> c);
}
class MyList<E> implements MyCollection<E> {
	public boolean contains(E o) {return false;}
	public boolean containsAll(Collection<? extends E> c) {return false;}

	public static void main(String[] args)  {
		Object obj = "one";
		MyList<Object> objs = MyList.of("one", 2, 3.5, 4);
		MyList<Integer> ints = MyList.of(2, 4);
		assert objs.contains(obj);
		assert objs.containsAll(ints);
		assert ! ints.contains(obj);             // compile-time error
		assert ! ints.containsAll(objs);         // compile-time error
	}
}