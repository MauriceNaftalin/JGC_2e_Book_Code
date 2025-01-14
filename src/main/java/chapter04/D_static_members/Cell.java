package chapter04.D_static_members;
// ch04_1_4
import java.util.concurrent.atomic.AtomicInteger;

class Cell<T> {
    private final int id;
    private final T value;
    private final static AtomicInteger count = new AtomicInteger();
    private static int nextId() { return count.getAndIncrement(); }
    public Cell(T value) {
        this.value = value;
        id = nextId();
    }
    public T getValue() { return value; }
    public int getId() { return id; }
    public static int getCount() { return count.get(); }

	public static void main(String[] args)  {
		Cell<String> a = new Cell<String>("one");
		Cell<Integer> b = new Cell<Integer>(2);
		assert a.getId() == 0 && b.getId() == 1 && Cell.getCount() == 2;
	}
}