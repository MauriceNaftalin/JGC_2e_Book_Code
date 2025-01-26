package chapter04.B_how_erasure_works;
// ch04_1_10

class Integer_1 implements Comparable<Integer_1>, Comparable<Long> {
    // compile-time error, cannot implement two interfaces with same erasure
    private int value;
    // ...
    public int compareTo(Integer_1 i) {
        return (value < i.value) ? -1 : (value == i.value) ? 0 : 1;
    }
    public int compareTo(Long l) {
        return (value < l.intValue()) ? -1 : (value == l.intValue()) ? 0 : 1;
    }
    // ...

}