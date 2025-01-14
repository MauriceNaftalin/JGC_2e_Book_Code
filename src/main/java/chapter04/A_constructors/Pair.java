package chapter04.A_constructors;
// ch04_1_1

class Pair<T,U> {
  private final T first;
  private final U second;
  public Pair(T first, U second) {
        this.first = first;
        this.second = second;
  }
  public T getFirst() { return first; }
  public U getSecond() { return second; }

	public static void main(String[] args)  {
		Pair<String, Integer> pair1 = new Pair<String, Integer>("one",2);
		assert pair1.getFirst().equals("one") && pair1.getSecond() == 2;
		Pair pair2 = new Pair<String, Integer>("one",2);
	}
}