package org.jgcbook.chapter09.G_lambdas_and_streams;
// 11.7.1
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Program_1 {
	public static void main(String[] args)  {
		Point origin = new Point(0, 0);
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		List<Point> pointList = new ArrayList<>();
		for (Integer i : intList) {
		    pointList.add(new Point(i % 3, i / 3));
		}
		double maxDistance = 0;
		for (Point p : pointList) {
		    maxDistance = Math.max(p.distanceFrom(origin), maxDistance);
		}

	}
}