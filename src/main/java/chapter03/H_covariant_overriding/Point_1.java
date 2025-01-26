package chapter03.H_covariant_overriding;
// ch03_8_2

record Point_1(double x, double y)  {
    public Object clone() { return new Point_1(x, y); }

	public static void main(String[] args)  {
		Point_1 p = new Point_1(1, 2);
		Point_1 q = (Point_1)p.clone();
	}
}