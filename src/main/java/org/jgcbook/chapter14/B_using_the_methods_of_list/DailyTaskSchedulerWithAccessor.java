package org.jgcbook.chapter14.B_using_the_methods_of_list;
// 15b1

import org.jgcbook.chapter10.A_using_the_methods_of_collection.CodingTask;
import org.jgcbook.chapter12.C_navigable_set.Priority;
import org.jgcbook.chapter12.C_navigable_set.PriorityTask;
import org.jgcbook.chapter13.C_blocking_queue.StoppableTaskQueue;
import org.jgcbook.chapter13.C_blocking_queue.StoppableTaskQueueWithAccessor;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DailyTaskSchedulerWithAccessor {
    private final List<StoppableTaskQueueWithAccessor> schedule;
    private final int FORWARD_PLANNING_DAYS = 365;
    public DailyTaskSchedulerWithAccessor() {
        schedule = Stream.generate(StoppableTaskQueueWithAccessor::new)
                .limit(FORWARD_PLANNING_DAYS)
                .collect(Collectors.toCollection(CopyOnWriteArrayList::new));
    }
    public Optional<PriorityTask> getTopTask() {
        return schedule.stream()
                .map(StoppableTaskQueueWithAccessor::getFirstTask)
                .filter(Objects::nonNull)
                .findFirst();
    }
    // this method will be called at midnight to create a new day's
    // queue at the planning horizon. It removes and shuts down the
    // queue for day 0, and assigns its tasks to the new day 0
    public synchronized void rollOver() {
        schedule.add(new StoppableTaskQueueWithAccessor());
        StoppableTaskQueueWithAccessor oldDay = schedule.removeFirst();
        schedule.getFirst().addTasks(oldDay.shutDown());
    }
    public void addTask(PriorityTask task, int day) {
        addTasks(List.of(task), day);
    }
    public void addTasks(Collection<PriorityTask> tasks, int day) {
        if (day < 0 || day >= FORWARD_PLANNING_DAYS)
            throw new IllegalArgumentException("day out of range");
        while (! schedule.get(day).addTasks(tasks)) {
            // if addTasks() fails, shutdown has been initiated on this
            // queue. So it must be the day 0 queue that has already been
            // removed from the schedule. The correct action, then, is to
            // call addTasks() on the new day 0 queue.
        }
    }
    //  monitoring facility
    List<PriorityTask> tasksForDay(int day) {
        return schedule.get(day).getTaskList();
    }
    // tiny demonstration
    public static void main(String[] args) {
        PriorityTask guiCoding = new PriorityTask(new CodingTask("gui"), Priority.MEDIUM);
        PriorityTask logicCoding = new PriorityTask(new CodingTask("logic"), Priority.HIGH);
        DailyTaskSchedulerWithAccessor scheduler = new DailyTaskSchedulerWithAccessor();
        scheduler.addTask(guiCoding, 0);
        assert scheduler.tasksForDay(0).equals(List.of(guiCoding));
        scheduler.addTask(logicCoding, 1);
        scheduler.rollOver();
        assert scheduler.tasksForDay(0).equals(List.of(logicCoding, guiCoding));
    }
}