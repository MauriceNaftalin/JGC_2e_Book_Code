package org.jgcbook.chapter03.H_covariant_overriding;
// ch03_8_3
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

record Point_2(double x, double y) {
    public Point_2 clone() { return new Point_2(x, y); }

	public static void main(String[] args)  {
		Point_2 p = new Point_2(1, 2);
		Point_2 q = p.clone();

		Map<Class<?>,Boolean> returnToBridge = (Arrays.stream(Point_2.class.getMethods())
		        .filter(m -> m.getName().equals("clone"))
		        .collect(Collectors.toMap(Method::getReturnType, Method::isBridge)));
		assert returnToBridge.size() == 2;
		assert returnToBridge.get(Object.class);     // Object clone(Point_2) is a bridge method
		assert ! returnToBridge.get(Point_2.class);    // Point_2 clone(Point_2) is not a bridge method

	}
}