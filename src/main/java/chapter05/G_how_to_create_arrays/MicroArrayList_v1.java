package chapter05.G_how_to_create_arrays;
// ch06_5_3
import java.lang.reflect.Array;
import java.util.Arrays;

class MicroArrayList_v1<E> {
    private int size = 2;                   // test data
    private Object[] data = {"a", "b"};     // test data
    // ...
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        a = (T[])Array.newInstance(a.getClass().getComponentType(), size); // 1
        System.arraycopy(data, 0, a, 0, size);
        return a;
    }
    public static void main(String[] args) {
        MicroArrayList_v1<String> mal = new MicroArrayList_v1<>();
        String[] arr = mal.toArray(args);
        assert Arrays.equals(arr, new String[]{"a", "b"});
    }

}