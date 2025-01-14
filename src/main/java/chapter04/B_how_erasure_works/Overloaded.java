package chapter04.B_how_erasure_works;
// ch04_1_9
import java.util.List;

class Overloaded {
  public static int sum(List<Integer> ints) {
    int sum = 0;
    for (int i : ints) sum += i;
    return sum;
  }
  public static String sum(List<String> strings) {
    StringBuffer sum = new StringBuffer();
    for (String s : strings) sum.append(s);
    return sum.toString();
  }

}