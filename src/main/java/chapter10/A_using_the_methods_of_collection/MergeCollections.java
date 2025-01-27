package chapter10.A_using_the_methods_of_collection;
// 12a6
import java.util.Collection;
import java.util.HashSet;
import java.util.Collections;
import java.util.Set;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class MergeCollections {
    static <T extends Comparable<? super T>> List<T> merge
            (Collection<? extends T> c1, Collection<? extends T> c2) {
        List<T> mergedList = new ArrayList<T>();
        Iterator<? extends T> itr1 = c1.iterator();
        Iterator<? extends T> itr2 = c2.iterator();
        T c1Element = getNextElement(itr1);
        T c2Element = getNextElement(itr2);
        // each iteration will take a task from one of the iterators;
        // continue until neither iterator has any further tasks
        while (c1Element != null || c2Element != null) {
            // use the current c1 element if either the current c2
            // element is null, or both are non-null and the c1 element
            // precedes the c2 element in the natural order
            boolean useC1Element = c2Element == null ||
                    c1Element != null && c1Element.compareTo(c2Element) < 0;
            if (useC1Element) {
                mergedList.add(c1Element);
                c1Element = getNextElement(itr1);
            } else {
                mergedList.add(c2Element);
                c2Element = getNextElement(itr2);
            }
        }
        return mergedList;
    }
    static <E> E getNextElement(Iterator<E> itr) {
        if (itr.hasNext()){
            E nextElement = itr.next();
            if (nextElement == null) throw new NullPointerException();
            return nextElement;
        } else {
            return null;
        }
    }

	public static void main(String[] args)  {
		PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
		PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
		CodingTask databaseCode = new CodingTask("db");
		CodingTask guiCode = new CodingTask("gui");
		CodingTask logicCode = new CodingTask("logic");
		Collection<PhoneTask> phoneTasks = new HashSet<>();     //1
		Collection<CodingTask> codingTasks = new HashSet<>();
		Collection<Task> mondayTasks = new HashSet<>();
		Collection<Task> tuesdayTasks = new HashSet<>();
		Collections.addAll(phoneTasks, mikePhone, paulPhone);   //2
		Collections.addAll(codingTasks, databaseCode, guiCode, logicCode);
		Collections.addAll(mondayTasks, logicCode, mikePhone);
		Collections.addAll(tuesdayTasks, databaseCode, guiCode, paulPhone);
		assert phoneTasks.equals(Set.of(mikePhone, paulPhone));
		assert codingTasks.equals(Set.of(databaseCode, guiCode, logicCode));
		assert mondayTasks.equals(Set.of(logicCode, mikePhone));
		assert tuesdayTasks.equals(Set.of(databaseCode, guiCode, paulPhone));
		Collection<Task> sortedMondayTasks = new TreeSet<>(mondayTasks);
		Collection<Task> sortedTuesdayTasks = new TreeSet<>(tuesdayTasks);
		Collection<Task> mergedTasks =
		    MergeCollections.merge(sortedMondayTasks, sortedTuesdayTasks);
		assert mergedTasks.equals(
		    List.of(databaseCode, guiCode, logicCode, mikePhone, paulPhone));
	}
}