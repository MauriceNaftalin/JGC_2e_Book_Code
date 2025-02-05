package chapter10.A_using_the_methods_of_collection;
// 12a5
import java.util.Collection;
import java.util.HashSet;
import java.util.Collections;
import java.util.Set;

public class Snippet_4 {
	public static void main(String[] args)  {
		PhoneTask mikePhone = new PhoneTask("Mike", "987 6543");
		PhoneTask paulPhone = new PhoneTask("Paul", "123 4567");
		CodingTask databaseCode = new CodingTask("db");
		CodingTask guiCode = new CodingTask("gui");
		CodingTask logicCode = new CodingTask("logic");
		Collection<PhoneTask> phoneTasks = new HashSet<>();           
		Collection<CodingTask> codingTasks = new HashSet<>();
		Collection<Task> mondayTasks = new HashSet<>();
		Collection<Task> tuesdayTasks = new HashSet<>();
		Collections.addAll(phoneTasks, mikePhone, paulPhone);          
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

		boolean wasPresent = mondayTasks.remove(mikePhone);
		assert wasPresent;
		assert mondayTasks.equals(Set.of(logicCode, ruthPhone));

	}
}