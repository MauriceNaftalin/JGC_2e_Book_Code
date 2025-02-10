package org.jgcbook.chapter15.C_using_the_methods_of_map;
// 16c1
import org.jgcbook.chapter10.A_using_the_methods_of_collection.Task;
import org.jgcbook.chapter10.A_using_the_methods_of_collection.PhoneTask;
import org.jgcbook.chapter10.A_using_the_methods_of_collection.CodingTask;
import org.jgcbook.chapter12.C_navigable_set.Priority;
import java.util.EnumMap;
import java.util.Queue;
import java.util.ArrayDeque;

public class Snippet_1 {
	public static void main(String[] args)  {
		var taskMap = new EnumMap<Priority,Queue<Task>>(Priority.class);
		for (Priority p : Priority.values()) {
		  taskMap.put(p, new ArrayDeque<Task>());
		}
		// populate the queues, for example:
		taskMap.get(Priority.MEDIUM).add(new PhoneTask("Mike", "987 6543"));
		taskMap.get(Priority.HIGH).add(new CodingTask("db"));

		Queue<Task> highPriorityTaskList = taskMap.get(Priority.HIGH);

	}
}