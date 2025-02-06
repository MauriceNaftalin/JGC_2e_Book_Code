package chapter13.C_blocking_queue;
// 14c3
import chapter10.A_using_the_methods_of_collection.Task;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedTask implements Delayed {
    private final LocalDateTime endTime;
    private final Task task;
    private static Comparator<Delayed> dtComparator =
        Comparator.comparing(dt -> dt.getDelay(TimeUnit.MILLISECONDS));
    public DelayedTask(Task t, int daysDelay) {
        task = t;
        endTime = LocalDateTime.now().plusDays(daysDelay);
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(Duration.between(LocalDateTime.now(), endTime));
    }
    @Override
    public int compareTo(Delayed d) {
        return dtComparator.compare(this, d);
    }
    public Task getTask() {
        return task;
    }

}