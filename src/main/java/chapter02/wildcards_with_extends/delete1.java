package chapter02.wildcards_with_extends;
// ch02_2_1

interface Collection<E> {
  public boolean addAll(Collection<? extends E> c);

}