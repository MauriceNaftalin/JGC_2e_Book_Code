package chapter05.F_the_principle_of_truth_in_advertising;
// ch06_5_1

class WrongMicroArrayList_2<E> {
    private int size = 2;               // test data
    private Object[] data = {"a", "b"}; // test data
    public <T> T[] toArray(T[] a) {
        a = (T[])new Object[size];      // unchecked cast
        System.arraycopy(data, 0, a, 0, size);
        return a;
    }
    public static void main(String[] args) {
        var wma = new WrongMicroArrayList_2<>();
        String[] a = wma.toArray(args); // class cast exception
    }

}