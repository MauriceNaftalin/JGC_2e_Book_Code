package chapter03.A_comparable;
// ch03_1_8

record Event_3(String name, int millisecs) implements Comparable<Event_3> {
    public int compareTo(Event_3 other) {
        return Integer.compare(this.millisecs, other.millisecs);
    }

}