package chapter05.E_generic_array_creation;
// ch06_4_1

class WrongMicroArrayList_1<E> {
    private int size;
    private Object[] data;
    // ...
    public <T> T[] toArray(T[] a) {
        a = new T[size]; // compile error
        System.arraycopy(data, 0, a, 0, size);
        return a;
    }

}