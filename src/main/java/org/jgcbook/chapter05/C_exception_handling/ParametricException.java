package org.jgcbook.chapter05.C_exception_handling;
// ch06_3_2

class ParametricException<T> extends Exception {  // compile-time error
  private final T value;
  public ParametricException(T value) { this.value = value; }
  public T getValue() { return value; }

}