package org.jgcbook.chapter12.C_navigable_set;
// 13c2a
import org.jgcbook.chapter10.A_using_the_methods_of_collection.Task;
import org.jgcbook.chapter10.A_using_the_methods_of_collection.CodingTask;
import org.jgcbook.chapter10.A_using_the_methods_of_collection.PhoneTask;
import java.util.Collection;
import java.util.HashSet;
import java.util.Collections;
import java.util.Set;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Program_2 {
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

		NavigableSet<PriorityTask> priorityTasks = new TreeSet<PriorityTask>();
		priorityTasks.add(new PriorityTask(mikePhone, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(paulPhone, Priority.HIGH));
		priorityTasks.add(new PriorityTask(databaseCode, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(guiCode, Priority.LOW));
		assert priorityTasks.toString().equals("""
		    [PriorityTask[task=PhoneTask[name=Paul, number=123 4567], priority=HIGH], \
		    PriorityTask[task=CodingTask[spec=db], priority=MEDIUM], \
		    PriorityTask[task=PhoneTask[name=Mike, number=987 6543], priority=MEDIUM], \
		    PriorityTask[task=CodingTask[spec=gui], priority=LOW]]""");

		PriorityTask nextTask = priorityTasks.pollFirst();
		assert nextTask.toString().equals(
		     "PriorityTask[task=PhoneTask[name=Paul, number=123 4567], priority=HIGH]");

	}
}