package chapter12.C_navigable_set;
// 13c5
import chapter10.A_using_the_methods_of_collection.Task;
import chapter10.A_using_the_methods_of_collection.CodingTask;
import chapter10.A_using_the_methods_of_collection.PhoneTask;
import chapter10.A_using_the_methods_of_collection.EmptyTask;
import chapter10.A_using_the_methods_of_collection.Task;
import chapter10.A_using_the_methods_of_collection.CodingTask;
import chapter10.A_using_the_methods_of_collection.PhoneTask;
import chapter10.A_using_the_methods_of_collection.EmptyTask;
import chapter10.A_using_the_methods_of_collection.Task;
import chapter10.A_using_the_methods_of_collection.CodingTask;
import chapter10.A_using_the_methods_of_collection.PhoneTask;
import chapter10.A_using_the_methods_of_collection.EmptyTask;
import java.util.Collection;
import java.util.HashSet;
import java.util.Collections;
import java.util.Set;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.NavigableSet;
import java.util.NavigableSet;
import java.util.NavigableSet;

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
		NavigableSet<PriorityTask> priorityTasks = new TreeSet<PriorityTask>();
		priorityTasks.add(new PriorityTask(mikePhone, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(paulPhone, Priority.HIGH));
		priorityTasks.add(new PriorityTask(databaseCode, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(guiCode, Priority.LOW));
		assert(priorityTasks.toString()).equals("""
		    [PriorityTask[task=PhoneTask[name=Paul, number=123 4567], priority=HIGH], \
		    PriorityTask[task=CodingTask[spec=db], priority=MEDIUM], \
		    PriorityTask[task=PhoneTask[name=Mike, number=987 6543], priority=MEDIUM], \
		    PriorityTask[task=CodingTask[spec=gui], priority=LOW]]""");
		PriorityTask firstLowPriorityTask = new PriorityTask(new EmptyTask(), Priority.LOW);
		NavigableSet<PriorityTask> highAndMediumPriorityTasks =
		        priorityTasks.headSet(firstLowPriorityTask, false);
		assert(highAndMediumPriorityTasks.toString()).equals("""
		    [PriorityTask[task=PhoneTask[name=Paul, number=123 4567], priority=HIGH], \
		    PriorityTask[task=CodingTask[spec=db], priority=MEDIUM], \
		    PriorityTask[task=PhoneTask[name=Mike, number=987 6543], priority=MEDIUM]]""");
		PriorityTask firstMediumPriorityTask =
		  new PriorityTask(new EmptyTask(), Priority.MEDIUM);
		NavigableSet<PriorityTask> mediumPriorityTasks =
		  priorityTasks.subSet(firstMediumPriorityTask, true, firstLowPriorityTask, false);
		assert(mediumPriorityTasks.toString()).equals("""
		    [PriorityTask[task=CodingTask[spec=db], priority=MEDIUM], \
		    PriorityTask[task=PhoneTask[name=Mike, number=987 6543], priority=MEDIUM]]""");
		PriorityTask logicCodeMedium = new PriorityTask(logicCode, Priority.MEDIUM);
		priorityTasks.add(logicCodeMedium);
		assert(mediumPriorityTasks.toString()).equals("""
		    [PriorityTask[task=CodingTask[spec=db], priority=MEDIUM], \
		    PriorityTask[task=CodingTask[spec=logic], priority=MEDIUM], \
		    PriorityTask[task=PhoneTask[name=Mike, number=987 6543], priority=MEDIUM]]""");
	}
}