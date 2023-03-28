package code;

import interfaces.BinarySearchTreeADT;
import interfaces.BinaryTreeNodeADT;

import java.util.ArrayList;

public class  BinarySearchTree<T> implements BinarySearchTreeADT<T>
{
    private BinaryTreeNodeADT<T> root;
    private int size;

    // * Constructor
    public BinarySearchTree()
    {
        // ! EMPTY
    }

    //----------------------------------
    //      NOTE: ROOT METHODS
    //----------------------------------

    @Override public BinaryTreeNodeADT<T> getRoot()
    {
        return root;
    }

    @Override public void setRoot(BinaryTreeNodeADT node) throws Exception
    {
        // ! Check for NULL
        if(node == null)
        {
            throw new Exception("[ERROR]: Root can not be NULL");
        }
        else
        {
            this.root = node;
        }
    }

    //----------------------------------

    //----------------------------------
    //      NOTE: ADD / REMOVE METHODS
    //----------------------------------
    @Override public void addElement(T target) throws Exception
    {
        // ! Check for NULL
        if(target == null)
        {
            throw new Exception("[ERROR]: Element can not be NULL!");
        }

        // # Is Root NULL?
        if(root == null)
        {
            // # TRUE --> It becomes the Root of the tree
            this.root =  new TreeNode<T>(target);
        }

        // TODO: Find the place in tree --> Maybe make in separate method
        TreeNode current = (TreeNode) root; // # We must always start from the Root.
        TreeNode<T> newNode = new TreeNode<>(target);
        boolean foundPlace = false;

        while(!foundPlace)
        {
            // # Is it bigger than Root?
            if(current.compareTo(newNode) > 0)
            {
                // ! Check for left child
                if (current.getLeftChild() != null)
                {
                    // # If it has, make it the new "current"
                    current = (TreeNode) current.getLeftChild();
                }
                else
                {
                    // # Else make it the left child.
                    current.addLeftChild(newNode);
                    foundPlace = true;
                }
            }
            else
            {
                // ! Check for right child
                if(current.getRightChild() != null)
                {
                    // # If it has, make it the new "current"
                    current = (TreeNode) current.getRightChild();
                }
                else
                {
                    // # Else make it the right child.
                    current.addRightChild(newNode);
                    foundPlace = true;
                }


            }



        }
    }

    @Override public T removeElement(T target)
    {
        // # Is Root?
        // * If it is, find a new Root...

        // ¤ LOOP
        // # Is smaller than "current"? --> Right
        // # Otherwise --> Left
        // ¤ LOOP --> Until it is found.

        // # Is Leaf?
        // * if YES --> Just remove it.
        // * if NOT --> Make rotations...

        return null;
    }
    //----------------------------------

    //----------------------------------
    //      NOTE: MIN/MAX METHODS
    //----------------------------------
    @Override public T removeMin()
    {
        // ¤ LOOP
        // * GO RIGHT
        // ¤ LOOP --> Until it can't no more.
        // ! REMOVE IT.

        return null;
    }

    @Override public T removeMax()
    {
        // ¤ LOOP
        //  * GO LEFT
        // ¤ LOOP --> Until it can't no more.
        // ! REMOVE IT

        return null;
    }

    @Override public T findMin()
    {
        // ¤ LOOP
        //  * GO RIGHT
        // ¤ LOOP --> Until it can't no more.
        // # Return it.

        return null;
    }

    @Override public T findMax()
    {
        // ¤ LOOP
        //  * GO RIGHT
        // ¤ LOOP --> Until it can't no more.
        // # Return it.

        return null;
    }
    //----------------------------------

    // NOTE: ISEMPTY
    @Override public boolean isEmpty()
    {
        // # Is Root set?
        // * TRUE --> NOT Empty
        // ! FALSE --> Empty
        return root == null;
    }

    // NOTE: SIZE
    @Override public int size()
    {
        return size;
    }
    // NOTE: HEIGHT
    @Override public int height()
    {
        // NOTE: Find the longest path of the tree.
        // * That is the height.

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
