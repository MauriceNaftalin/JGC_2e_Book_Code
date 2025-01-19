package chapter06.B_reflected_types_are_reifiable_types;
// ch07_1_6
import java.util.List;

class ClassLiteral {
  public Class<?> k = List<Integer>.class; // syntax error

}