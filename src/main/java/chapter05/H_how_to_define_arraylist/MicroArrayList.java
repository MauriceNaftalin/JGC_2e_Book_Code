package chapter05.H_how_to_define_arraylist;
// ch06_8_1
import java.util.AbstractList;
import java.util.Objects;
import java.util.RandomAccess;

class MicroArrayList<E> extends AbstractList<E> implements RandomAccess {
    Object[] data;
    private int size;
    public MicroArrayList() { data = new Object[10]; }
    public int size() { return size; }
    public E get(int i) {
        Objects.checkIndex(i,size);
        return (E)data[i];       // unchecked cast
    }
    public E set(int i, E elt) {
        Objects.checkIndex(i,size);
        E old = (E)data[i];      // unchecked cast
        data[i] = elt;
        return old;
    }
    public void add(int i, E elt) {
        Objects.checkIndex(i,size+1);
        if (size + 1 > data.length) {
            // ignore possibility of overflow
            data = Arrays.copyOf(data, data.length + (data.length << 1));
        }
        System.arraycopy(data, i, data, i+1, size-i);
        data[i] = elt;
        size++;
    }
    public E remove(int i) {
        Objects.checkIndex(i,size);
        E old = (E)data[i];      // unchecked cast
        size--;
        System.arraycopy(data, i+1, data, i, size-i);
        data[size] = null;       // release last element for potential garbage collection
        return old;
    }
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[])Arrays.copyOf(data, size, a.getClass()); // unchecked cast
        System.arraycopy(data, 0, a, 0, size);
        if (a.length > size) a[size] = null;  // sentinel
        return a;
    }
    public Object[] toArray() { return Arrays.copyOf(data, size); }

}