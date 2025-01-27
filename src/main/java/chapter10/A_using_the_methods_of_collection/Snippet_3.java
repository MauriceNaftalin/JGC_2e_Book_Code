package chapter10.A_using_the_methods_of_collection;
// 12a2
import java.util.Collection;
import java.util.HashSet;
import java.util.Collections;
import java.util.Set;
import java.util.Iterator;

public class Snippet_3 {
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
		PhoneTask ruthPhone = new PhoneTask("Ruth", "567 1234");
		mondayTasks.add(ruthPhone);
		assert mondayTasks.equals(Set.of(logicCode, mikePhone, ruthPhone));
		Collection<Task> allTasks_1 = new HashSet<>(mondayTasks);
		allTasks_1.addAll(tuesdayTasks);
		assert allTasks_1.equals(Set.of(logicCode, mikePhone, ruthPhone,
		        databaseCode, guiCode, paulPhone));
		boolean wasPresent = mondayTasks.remove(mikePhone);
		assert wasPresent;
		assert mondayTasks.equals(Set.of(logicCode, ruthPhone));
		mondayTasks.clear();
		assert mondayTasks.equals(Collections.EMPTY_SET);
		Collection<Task> tuesdayNonPhoneTasks = new HashSet<>(tuesdayTasks);
		tuesdayNonPhoneTasks.removeAll(phoneTasks);
		assert tuesdayNonPhoneTasks.equals(Set.of(databaseCode, guiCode));
		Collection<Task> phoneTuesdayTasks = new HashSet<>(tuesdayTasks);
		phoneTuesdayTasks.retainAll(phoneTasks);
		assert phoneTuesdayTasks.equals(Set.of(paulPhone));
		Collection<PhoneTask> tuesdayPhoneTasks = new HashSet<>(phoneTasks);
		tuesdayPhoneTasks.retainAll(tuesdayTasks);
		assert tuesdayPhoneTasks.equals(Set.of(paulPhone));
		assert tuesdayPhoneTasks.contains(paulPhone);
		assert tuesdayTasks.containsAll(tuesdayPhoneTasks);
		assert mondayTasks.isEmpty();
		assert mondayTasks.size() == 0;
		for (Iterator<Task> it = tuesdayTasks.iterator() ; it.hasNext() ; ) {
		  Task t = it.next();
		  if (t instanceof PhoneTask) {
		    it.remove();
		  }
		  assert tuesdayTasks.equals(Set.of(databaseCode, guiCode));
		}
	}
}