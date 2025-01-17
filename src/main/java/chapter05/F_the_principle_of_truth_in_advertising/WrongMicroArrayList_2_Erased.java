package chapter05.F_the_principle_of_truth_in_advertising;
// ch06_5_2

class WrongMicroArrayList_2_Erased {
    private int size = 2;                           // test data
    private Object[] data = {"a", "b"};             // test data
    public Object[] toArray(Object[] a) {
        a = (Object[])new Object[size];             // unchecked cast
        System.arraycopy(data, 0, a, 0, size);
        return a;
    }
    public static void main(String[] args) {
        var wma = new WrongMicroArrayList_2_Erased();
        String[] arr = (String[])wma.toArray(args); // class cast exception
    }

}