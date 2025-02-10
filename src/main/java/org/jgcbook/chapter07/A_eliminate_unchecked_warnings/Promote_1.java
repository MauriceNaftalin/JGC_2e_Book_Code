package org.jgcbook.chapter07.A_eliminate_unchecked_warnings;
// ch08_1_1
import java.util.List;

class Promote_1 {
  public static List<String> promote(List<Object> objs) {
    for (Object o : objs)
      if (!(o instanceof String))
        throw new ClassCastException();
    return (List<String>)(List<?>)objs; // unchecked cast
  }
  public static void main(String[] args) {
    List<Object> objs1 = List.of("one","two");
    List<Object> objs2 = List.of(1,"two");
    List<String> strs1 = promote(objs1);
    assert strs1 == (List<?>)objs1;
    try {
      List<String> strs2 = promote(objs2);
      assert false;
    } catch (ClassCastException e) {
      // should always get here
    }
  }

}