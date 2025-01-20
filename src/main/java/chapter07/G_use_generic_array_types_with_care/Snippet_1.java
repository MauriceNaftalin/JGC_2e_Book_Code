package chapter07.G_use_generic_array_types_with_care;
// ch08_7_3

public class Snippet_1 {
	public static void main(String[] args)  {
		ArrayTreeNode<Integer> integerNode = new ArrayTreeNode<>(3, 2);
		ArrayTreeNode<? extends Number>[] numberTreeNodes = integerNode.getChildren();
		numberTreeNodes[0] = new ArrayTreeNode<>(1.0, 2);
		Integer data = integerNode.getChildren()[0].getData();  // class cast exception
	}
}