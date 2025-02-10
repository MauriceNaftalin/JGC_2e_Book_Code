package org.jgcbook.chapter17.A_avoid_anemic_domain_models;
// 19a1
import java.time.Duration;

public interface Task extends Comparable<Task> {
    @Override
    default int compareTo(Task t) {
       return toString().compareTo(t.toString());
    }
    Duration duration();

}