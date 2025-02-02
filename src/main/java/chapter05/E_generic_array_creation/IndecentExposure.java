package chapter05.E_generic_array_creation;
// ch06_4_2
import java.util.List;

class IndecentExposure {
  public static List<Integer>[] twoLists() {
    List<Integer> a = List.of(1, 2, 3);
    List<Integer> b = List.of(4, 5, 6);
    return new List<Integer>[] {a, b};  // compile-time error
  }

}