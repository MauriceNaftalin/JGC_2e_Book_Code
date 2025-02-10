package org.jgcbook.chapter13.C_blocking_queue;
// 14c2
import org.jgcbook.chapter10.A_using_the_methods_of_collection.Task;
import org.jgcbook.chapter10.A_using_the_methods_of_collection.CodingTask;
import org.jgcbook.chapter10.A_using_the_methods_of_collection.PhoneTask;
import java.util.Collection;
import java.util.HashSet;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

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

		BlockingQueue<DelayedTask> reminderQueue = new DelayQueue<DelayedTask>();
		reminderQueue.offer(new DelayedTask(databaseCode, 1));
		reminderQueue.offer(new DelayedTask(guiCode, 2));
		// ...
		// now get the first reminder task that is ready to be processed
		DelayedTask t1 = reminderQueue.poll();
		if (t1 == null) {
		  // no reminders ready yet
		} else {
		  // process t1
		}

	}
}