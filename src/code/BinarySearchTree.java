package code;

import interfaces.BinarySearchTreeADT;
import java.util.ArrayList;

public class  BinarySearchTree<T> implements BinarySearchTreeADT<T>
{
    private TreeNode<T> root;
    private int size;

    // * Constructor
    public BinarySearchTree()
    {
        // ! EMPTY
    }

    //----------------------------------
    //      NOTE: ROOT METHODS
    //----------------------------------

    @Override public TreeNode<T> getRoot()
    {
        return null;
    }

    @Override public void setRoot(TreeNode node)
    {

    }

    //----------------------------------

    //----------------------------------
    //      NOTE: ADD / REMOVE METHODS
    //----------------------------------
    @Override public void addElement(T target)
    {

    }

    @Override public T removeElement(T target)
    {
        return null;
    }
    //----------------------------------

    //----------------------------------
    //      NOTE: MIN/MAX METHODS
    //----------------------------------
    @Override public T removeMin()
    {
        return null;
    }

    @Override public T removeMax()
    {
        return null;
    }

    @Override public T findMin()
    {
        return null;
    }

    @Override public T findMax()
    {
        return null;
    }
    //----------------------------------

    // NOTE: ISEMPTY
    @Override public boolean isEmpty()
    {
        return false;
    }

    // NOTE: SIZE
    @Override public int size()
    {
        return 0;
    }
    // NOTE: HEIGHT
    @Override public int height()
    {
        return 0;
    }

    // NOTE: CONTAINS
    @Override public boolean contains(Object element)
    {
        return false;
    }

    //----------------------------------
    //      NOTE: TRAVEL METHODS
    //----------------------------------
    @Override public ArrayList<T> inOrder()
    {
        return null;
    }

    @Override public ArrayList<T> preOrder()
    {
        return null;
    }

    @Override public ArrayList<T> postOrder()
    {
        return null;
    }

    @Override public ArrayList<T> levelOrder()
    {
        return null;
    }
    //----------------------------------

}
