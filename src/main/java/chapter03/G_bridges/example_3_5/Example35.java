package chapter03.G_bridges.example_3_5;
// ch03_7_1
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

interface Comparable<T> {
    public int compareTo(T other);
}
record Point(double x, double y) implements Comparable<Point> {
    public int compareTo(Point p) {
        return Double.compare(this.x * this.x + this.y * this.y,
                              p.x * p.x + p.y * p.y);
    }

	public static void main(String[] args)  {
		Map<Class<?>, Boolean> typeToBridge = (Arrays.stream(Point.class.getMethods())
		    .filter(m -> m.getName().equals("compareTo"))
		    .collect(Collectors.toMap(m -> m.getParameterTypes()[0], Method::isBridge)));
		assert typeToBridge.size() == 2;
		assert ! typeToBridge.get(Point.class);    // compareTo(Point) is not a bridge method
		assert typeToBridge.get(Object.class);     // compareTo(Object) is a bridge method
	}
}