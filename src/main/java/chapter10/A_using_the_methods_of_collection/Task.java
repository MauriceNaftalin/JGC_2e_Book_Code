package chapter10.A_using_the_methods_of_collection;
// 12a1

public interface Task extends Comparable<Task> {
    default int compareTo(Task t) {
        return toString().compareTo(t.toString());
    }
}

record CodingTask(String spec) implements Task {}
record PhoneTask(String name, String number) implements Task {}

record EmptyTask() implements Task {
    public String toString() {
        return "";
    }

}