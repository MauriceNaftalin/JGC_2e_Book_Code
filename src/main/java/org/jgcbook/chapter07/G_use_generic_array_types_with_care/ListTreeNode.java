package org.jgcbook.chapter07.G_use_generic_array_types_with_care;
// ch08_7_1
import java.util.List;
import java.util.ArrayList;

class ListTreeNode<T> {
    private T data;
    private final List<ListTreeNode<T>> children;
    public ListTreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }
    public void addChild(ListTreeNode<T> child) { this.children.add(child); }
    public void removeChild(ListTreeNode<T> child) { this.children.remove(child); }
    public T getData() { return data; }
    public List<ListTreeNode<T>> getChildren() { return children; }

}