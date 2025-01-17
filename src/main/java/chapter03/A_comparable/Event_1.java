package chapter03.A_comparable;
// ch03_1_6

record Event_1(String name, int millisecs) implements Comparable<Event_1> {
    public int compareTo(Event_1 other) {
        return this.millisecs < other.millisecs ? -1
               : this.millisecs == other.millisecs ? 0
               : 1;
    }

}