package org.jgcbook.chapter17.B_ownership;
// 19b1
import org.jgcbook.chapter17.A_avoid_anemic_domain_models.Task;
import java.time.Duration;
import java.util.Collections;
import java.util.Set;

public class Project {
    private final String name;
    private final Set<Task> tasks;
    private Duration totalDuration;
    public Project(String name, Set<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
        totalDuration = tasks.stream()
            .map(Task::duration)
            .reduce(Duration.ZERO, Duration::plus);
    }
    public String getName() { return name; }
    public Duration getTotalDuration() { return totalDuration; }
    public Set<Task> getTasks() {
        return Collections.unmodifiableSet(tasks);
    }
    public void addTask(Task task) {
        tasks.add(task);
        totalDuration = totalDuration.plus(task.duration());
    }
    public void removeTask(Task task) {
        tasks.remove(task);
        totalDuration = totalDuration.minus(task.duration());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        if (!name.equals(project.name)) return false;
        return tasks.equals(project.tasks);
    }
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + tasks.hashCode();
        return result;
    }

}