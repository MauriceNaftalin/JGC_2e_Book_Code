package chapter12.C_navigable_set;
// 13c1
import chapter10.A_using_the_methods_of_collection.Task;
import java.util.Comparator;

public record PriorityTask(Task task, Priority priority)
    implements Comparable<PriorityTask> {
    static Comparator<PriorityTask> priorityTaskCmpr =
        Comparator.comparing(PriorityTask::priority)
            .thenComparing(PriorityTask::task);
    public int compareTo(PriorityTask pt) {
        return priorityTaskCmpr.compare(this, pt);
    }

}