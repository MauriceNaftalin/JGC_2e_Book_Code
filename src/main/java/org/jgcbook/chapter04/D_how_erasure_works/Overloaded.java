package org.jgcbook.chapter04.D_how_erasure_works;
// ch04_1_9
import java.util.List;

class Overloaded {
    // compile-time error, cannot implement two interfaces with same erasure
public static int sum(List<Integer> ints) {
    int sum = 0;
    for (int i : ints) sum += i;
    return sum;
  }
  public static String sum(List<String> strings) {
    StringBuilder sum = new StringBuilder();
    for (String s : strings) sum.append(s);
    return sum.toString();
  }

}