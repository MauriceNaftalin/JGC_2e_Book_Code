package chapter07.G_use_generic_array_types_with_care;
// ch08_7_2

class ArrayTreeNode<T> {
    private T data;
    private final ArrayTreeNode<T>[] children;
    public ArrayTreeNode(T data, int childCount) {
        this.data = data;
        this.children =
          (ArrayTreeNode<T>[]) new ArrayTreeNode[childCount];  // unchecked cast
    }
    public void replaceData(T newData) { this.data = newData; }
    public void replaceChild(ArrayTreeNode<T> child, int index) { this.children[index] = child; }
    public ArrayTreeNode<T>[] getChildren() { return children; }
    public T getData() { return data; }

}