package org.jgcbook.chapter13.B_implementing_queue;
// 14b1
import org.jgcbook.chapter12.C_navigable_set.Priority;
import org.jgcbook.chapter12.C_navigable_set.PriorityTask;
import org.jgcbook.chapter10.A_using_the_methods_of_collection.Task;
import org.jgcbook.chapter10.A_using_the_methods_of_collection.CodingTask;
import org.jgcbook.chapter10.A_using_the_methods_of_collection.PhoneTask;
import java.util.Collection;
import java.util.HashSet;
import java.util.Collections;
import java.util.Set;
import java.util.Queue;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Snippet_1 {
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

		final int INITIAL_CAPACITY = 10;
		Comparator<PriorityTask> priorityComp = Comparator.comparing(PriorityTask::priority);
		Queue<PriorityTask> priorityQueue = new PriorityQueue<>(INITIAL_CAPACITY, priorityComp);
		priorityQueue.add(new PriorityTask(mikePhone, Priority.MEDIUM));
		priorityQueue.add(new PriorityTask(paulPhone, Priority.HIGH));
		PriorityTask nextTask = priorityQueue.poll();
		System.out.println(nextTask);
		// ...
		nextTask = priorityQueue.poll();

	}
}