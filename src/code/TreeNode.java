package code;

import interfaces.BinaryTreeNodeADT;

public class TreeNode<T> implements BinaryTreeNodeADT<T> {
    // # Element
    private T element;

    // ¤ Children
    private TreeNode<T> left;
    private TreeNode<T> right;

    // * Constructor
    public TreeNode( T element)
    {
        this.element = element;
    }

    @Override public void setElement(T target)
    {
        this.element = target;
    }
    @Override public T getElement(T target)
    {
        return element;
    }
    @Override public void addLeftChild(BinaryTreeNodeADT<T> child)
    {
        this.left = (TreeNode<T>) child;
    }
    @Override
    public void addRightChild(BinaryTreeNodeADT<T> child)
    {
        this.right = (TreeNode<T>) child;
    }
    @Override public BinaryTreeNodeADT<T> getLeftChild()
    {
        return left;
    }
    @Override public BinaryTreeNodeADT<T> getRightChild()
    {
        return right;
    }

    // TODO: Implement a compareTo method... xD
    @Override public int compareTo(T o)
    {
        return 0;
    }
}
