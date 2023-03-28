package interfaces;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public interface BinaryTreeADT<T>
{
    TreeNode getRoot(); // * Returns a reference to the Root or null if tree is empty
    void setRoot(TreeNode node); // * Set the Root of the tree
    boolean isEmpty(); // * Determines whether the tree is empty
    int size(); // * Returns the number of elements in the tree
    boolean contains(T element); // * Determines if an element is present in the tree
    ArrayList<T> inOrder(); // * Returns a InOrder representation of the tree or Null if empty
    ArrayList<T> preOrder(); // * Returns a PreOrder representation of the tree or Null if empty
    ArrayList<T> postOrder(); // * Returns a PostOrder representation of the tree or Null if empty
    ArrayList<T> levelOrder(); // * Returns a LevelOrder representation of the tree or Null if empty
    int height(); // * Returns the height of the tree or -1 if empty.

}
