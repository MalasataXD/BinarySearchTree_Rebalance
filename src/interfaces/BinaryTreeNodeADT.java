package interfaces;

import code.TreeNode;

public interface BinaryTreeNodeADT<T extends Comparable<T>> extends Comparable<T>
{
    void setElement(T target);  // * Store the element in the Node
    T getElement(); // * Returns the element from the Node
    void addLeftChild(BinaryTreeNodeADT<T> child); // * Add a left child to the Node
    void addRightChild(BinaryTreeNodeADT<T> child); // * Add a right child to the Node
    BinaryTreeNodeADT<T> getLeftChild(); // * Returns a reference to the left child or null if there is no child.
    BinaryTreeNodeADT<T> getRightChild(); // * Returns a reference to the right child or null if there is no child.
}
