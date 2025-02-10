package org.jgcbook.chapter10.A_using_the_methods_of_collection;
// 12a1

public interface Task extends Comparable<Task> {
    default int compareTo(Task t) {
        return toString().compareTo(t.toString());
    }

}