package chapter12.B_sequenced_set;
// 13b1
import java.util.LinkedHashSet;
import java.util.Collections;
import java.util.SequencedSet;

public class Snippet_1 {
	public static void main(String[] args)  {
		SequencedSet<Character> lhs = LinkedHashSet.<Character>newLinkedHashSet(3);
		Collections.addAll(lhs, 'j', 'i', 'b');
		// iterators of a LinkedHashSet return their elements in insertion order:
		assert lhs.toString().equals("[j, i, b]");
		// the methods of SequencedSet are all available:
		assert lhs.getLast() == 'b';
		assert lhs.reversed().toString().equals("[b, i, j]");
	}
}