package chapter03.comparable.comparing_integral_values;
// ch03_1_8

record Event(String name, int millisecs) implements Comparable<Event> {
    public int compareTo(Event other) {
        return Integer.compare(this.millisecs, other.millisecs);
    }

}