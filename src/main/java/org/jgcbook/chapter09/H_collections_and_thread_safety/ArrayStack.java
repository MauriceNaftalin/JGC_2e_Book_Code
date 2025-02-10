package org.jgcbook.chapter09.H_collections_and_thread_safety;
// 11.7.3

interface Stack {
  public void push(int elt);
  public int pop();
  public boolean isEmpty();
}
class ArrayStack implements Stack {
    private final int MAX_ELEMENTS = 10;
    private int[] stack;
    private int index;
    public ArrayStack() {
        stack = new int[MAX_ELEMENTS];
        index = 0;
    }
    public void push(int elt) {
        if (index != stack.length) {
            stack[index] = elt;             // 1
            index++;                        // 2
        } else {
            throw new IllegalStateException("stack overflow");
        }
    }
    public int pop() {
        if (index != 0) {
            return stack[--index];
        } else {
            throw new IllegalStateException("stack underflow");
        }
    }
    public boolean isEmpty() { return index == 0; }

}