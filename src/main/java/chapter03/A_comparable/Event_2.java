package chapter03.A_comparable;
// ch03_1_7

record Event_2(String name, int millisecs) implements Comparable<Event_2> {
    public int compareTo(Event_2 other) {
        // bad implementation &mdash; don't do this
        return this.millisecs - other.millisecs;
    }

}