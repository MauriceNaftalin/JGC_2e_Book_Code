package chapter05.the_principle_of_indecent_exposure;
// ch06_9_3
import java.util.List;

// DeceptiveLibrary.java:
public class DeceptiveLibrary {
   public static List<Integer>[] createIntLists(int size) {
      List<Integer>[] intLists =
         (List<Integer>[]) new List[size];  // unchecked cast //1
      for (int i = 0; i < size; i++)
         intLists[i] = List.of(i+1);
      return intLists;
   }
}
// InnocentClient.java:
class InnocentClient {
   public static void main(String[] args) {
      List<Integer>[] intLists = DeceptiveLibrary.createIntLists(1);
      List<? extends Number>[] numLists = intLists;
      numLists[0] = List.of(1.01);
      int i = intLists[0].get(0);           // class cast exception!
   }

}