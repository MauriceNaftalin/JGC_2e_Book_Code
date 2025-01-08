package chapter07.eliminate_unchecked_warnings;
// ch06_2_6
import java.util.List;

class Promote {
  public static List<String> promote(List<Object> objs) {
    for (Object o : objs)
      if (!(o instanceof String))
        throw new ClassCastException();
    return (List<String>)(List<?>)objs; // unchecked cast
  }

}