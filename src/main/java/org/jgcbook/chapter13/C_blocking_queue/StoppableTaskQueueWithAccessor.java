package org.jgcbook.chapter13.C_blocking_queue;
// 14c1

import org.jgcbook.chapter12.C_navigable_set.PriorityTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;

public class StoppableTaskQueueWithAccessor {
    private final int MAXIMUM_PENDING_OFFERS = Integer.MAX_VALUE;
    private final BlockingQueue<PriorityTask> taskQueue = new PriorityBlockingQueue<>();
    private final Semaphore semaphore = new Semaphore(MAXIMUM_PENDING_OFFERS);
    private volatile boolean isStopping;
    // return true if the task was successfully placed on the queue, false
    // if the queue is being shut down.
    public boolean addTask(PriorityTask task) {
        return addTasks(List.of(task));
    }
    // return true if the tasks in the supplied collection were successfully
    // placed on the queue, false if the queue is being shut down
    public boolean addTasks(Collection<PriorityTask> tasks) {
        if (isStopping) return false;
        if (! semaphore.tryAcquire()) {
            return false;
        } else {
            taskQueue.addAll(tasks);
            semaphore.release();
            return true;
        }
    }
    // return the head task from the queue, or null if no task is available
    public PriorityTask getFirstTask() {
        return taskQueue.poll();
    }
    // stop the queue, wait for producers to finish, then return the contents
    public Collection<PriorityTask> shutDown() {
        isStopping = true;
        // blocks until all outstanding addTasks() calls have completed
        semaphore.acquireUninterruptibly(MAXIMUM_PENDING_OFFERS);
        List<PriorityTask> returnCollection = new ArrayList<>();
        taskQueue.drainTo(returnCollection);
        return returnCollection;
    }
    // monitoring facility
    public List<PriorityTask> getTaskList() {
        BlockingQueue<PriorityTask> copyQueue = new PriorityBlockingQueue<>(taskQueue);
        List<PriorityTask> taskList = new ArrayList<>();
        copyQueue.drainTo(taskList);
        return taskList;
    }
}