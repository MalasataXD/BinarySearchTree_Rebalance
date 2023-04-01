package code;

import interfaces.BinarySearchTreeADT;
import interfaces.BinaryTreeNodeADT;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeADT<T>
{
    // # FIELDS
    private TreeNode root;
    private int size = 0;
    private T element;

    // ¤ Constructor
    public BinarySearchTree() {
        // ! EMPTY
    }

    // # DONE !
    @Override public void addElement(T target) throws Exception {
        // ! Check for NULL
        if(target == null) {
            throw new Exception("Input can not be NULL!");
        }

        // ? Is ROOT set?
        if(root == null) {
            root = new TreeNode<>(target);
            size++;
            return;
        }

        // ? Exists in Tree?
        if(contains(target))
        {
            throw new Exception("Element already exists in Tree!");
        }

        TreeNode<T> current = root; // * Start from ROOT
        TreeNode<T> newNode = new TreeNode<>(target);
        boolean hasFoundSpot = false;
        size++;
        while(!hasFoundSpot) // * Look for spot
        {
            // # Smaller?
            if(current.compareTo(target) <= 0)
            {
                // # Then we know that is smaller than "current"
                if(current.getLeftChild() != null)
                {
                    // # Change "current" to left child
                    current = (TreeNode<T>) current.getLeftChild();
                }
                else
                {
                    // # Make target the left child to "current"
                    current.addLeftChild(new TreeNode<>(target));
                    hasFoundSpot = true;
                }
            }
            // # Bigger?
            else if(current.compareTo(target) >= 0)
            {
                // # Then we know that is bigger than "current"
                if(current.getRightChild() != null)
                {
                    // # Change "current" to right child
                    current = (TreeNode<T>) current.getRightChild();
                }
                else
                {
                    // # Make target the right to "current"
                    current.addRightChild(new TreeNode<>(target));
                    hasFoundSpot = true;
                }
            }
        }
    }

    // WIP
    @Override public T removeElement(T target) throws Exception {
        // ? Is in tree?
        if(!contains(target))
        {
            throw new Exception("Can not remove elements not in tree");
        }

        // TODO: Look for target?
        // # Is Root?
        // * If it is, find a new Root....

        // ¤ LOOP
        // # Is current?
        // # Smaller than "current"?
        // # Bigger than "current"?
        // ¤ LOOP

        // ! Is Leaf?
        // * YES --> REMOVE IT
        // ¤ NO --> MAKE ROTATIONS


        return null;
    }

    // # DONE!
    @Override public boolean contains(Comparable element)
    {
        TreeNode<T> current = root; // * Start from Root
        boolean hasFound = false;
        boolean isDoneLooking = false;

        while(!isDoneLooking) // * Look for target
        {
            // # Is this it?
            if(current.getElement().compareTo((T) element) == 0)
            {
                isDoneLooking = true;
                hasFound = true;
            }

            // # Smaller?
            if(current.getElement().compareTo((T) element) < 0)
            {
                // # Then we know that is smaller than "current"
                if(current.getLeftChild() != null)
                {
                    // # Change "current" to left child
                    current = (TreeNode<T>) current.getLeftChild();
                }
                else
                {
                    // ! Stop looking
                    isDoneLooking = true;
                }
            }
            // # Bigger?
            else if(current.getElement().compareTo((T) element) > 0)
            {
                // # Then we know that is bigger than "current"
                if(current.getRightChild() != null)
                {
                    // # Change "current" to right child
                    current = (TreeNode<T>) current.getRightChild();
                }
                else
                {
                    // ! Stop looking
                    isDoneLooking = true;
                }
            }
        }

        return hasFound;
    }



    @Override public T removeMin()
    {
        return null;
    }

    @Override public T removeMax() {
        return null;
    }

    @Override public T findMin() {
        return null;
    }

    @Override public T findMax() {
        return null;
    }


    // # DONE!
    @Override public BinaryTreeNodeADT getRoot() {
        return root;
    }
    // # DONE!
    @Override public void setRoot(BinaryTreeNodeADT node) {
        this.root = (TreeNode) node;
    }
    // # DONE
    @Override public boolean isEmpty() {
        return root == null;
    }
    // # DONE
    @Override public int size() {
        return size;
    }

    @Override
    public ArrayList inOrder() {
        return null;
    }
    @Override
    public ArrayList preOrder() {
        return null;
    }
    @Override
    public ArrayList postOrder() {
        return null;
    }
    @Override
    public ArrayList levelOrder() {
        return null;
    }

    @Override
    public int height() {
        return 0;
    }
}
