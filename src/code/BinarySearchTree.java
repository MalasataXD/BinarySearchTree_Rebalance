package code;

import interfaces.BinarySearchTreeADT;
import interfaces.BinaryTreeNodeADT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
            if(current.compareTo(target) > 0)
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
            else if(current.compareTo(target) < 0)
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

    // # DONE !
    @Override public T removeElement(T target) throws Exception {
        // ! Check for Null?
        if(target == null)
        {
            throw new Exception("Target can not be NULL!");
        }

        // ? Is in tree?
        if(!contains(target))
        {
            throw new Exception("Can not remove elements not in tree");
        }

        TreeNode parent = null; // # This is used to keep track of the parent Node
        TreeNode current = (TreeNode) getRoot(); // * Always start from the Root

        while(current != null)
        {
            // * We have found the Node, we want to remove
            if(current.getElement().compareTo(target) == 0)
            {
                break;
            }
            // # Smaller?
            else if(current.getElement().compareTo(target) > 0)
            {
                parent = current;
                current = (TreeNode) current.getLeftChild();
            }
            // # Must be Bigger
            else
            {
                parent = current;
                current = (TreeNode) current.getRightChild();
            }
        }

        // # Find the correct remove method for the element
        if(current.getLeftChild() == null && current.getRightChild() == null)
        {
            removeLeafNode(parent,current);
        }
        else if(current.getLeftChild() == null || current.getRightChild() == null)
        {
            removeOneChild(parent,current);
        }
        else
        {
            removeTwoChildren(current);
        }



        return (T) current.getElement();
    }

    // ! Remove Leaf node
    private void removeLeafNode(TreeNode<T> parent, TreeNode<T> nodeToRemove)
    {
        // # Has Parent?
        if(parent == null)
        {
            // * If it does not have, it can only be Root
            root = null;
        }
        // # Left?
        else if(parent.getLeftChild() == nodeToRemove)
        {
            parent.addLeftChild(null);
        }
        // # Right?
        else if(parent.getRightChild() == nodeToRemove)
        {
            parent.addRightChild(null);
        }
    }
    // ! Remove with One child
    private void removeOneChild(TreeNode<T> parent, TreeNode<T> nodeToRemove)
    {
        // # Check for child.
        TreeNode<T> child = (TreeNode<T>) (nodeToRemove.getLeftChild() == null? nodeToRemove.getRightChild() : nodeToRemove.getLeftChild());

        // # Has Parent?
        if(parent == null)
        {
            // * If it does not have, it can only be Root
            root = child;
        }
        // # Left?
        else if(parent.getLeftChild() == nodeToRemove)
        {
            parent.addLeftChild(child);
        }
        // # Right?
        else if(parent.getRightChild() == nodeToRemove)
        {
            parent.addRightChild(child);
        }
    }
    // ! Remove with Two children.
    private void removeTwoChildren(TreeNode<T> nodeToRemove)
    {
        TreeNode<T> parent = nodeToRemove; // # Node we want to remove.
        // * We need to take the right child to ensure, that tree is maintained after the removal.
        TreeNode<T> successor = (TreeNode<T>) nodeToRemove.getRightChild();

        // # Find the smallest element in the sub rooted at the successor
        while(successor.getLeftChild() != null)
        {
            parent = successor;
            successor = (TreeNode<T>) successor.getLeftChild();
        }
        // * Set the element of the node to remove to the element of the successor.
        nodeToRemove.setElement(successor.getElement());


        if(parent == nodeToRemove)
        {
            parent.addRightChild(successor.getRightChild());
        }
        else
        {
            parent.addLeftChild(successor.getRightChild());
        }
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
            if(current.getElement().compareTo((T) element) > 0)
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
            else if(current.getElement().compareTo((T) element) < 0)
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

    // # DONE !
    @Override public T removeMin() {
        TreeNode<T> parent = null;
        TreeNode<T> current = (TreeNode<T>) getRoot();

        while(current.getLeftChild() != null)
        {
            parent = current;
            current = (TreeNode<T>) current.getLeftChild();
        }

        if(current.getLeftChild() == null && current.getRightChild() == null)
        {
            removeLeafNode(parent,current);
        }
        else if(current.getLeftChild() == null || current.getRightChild() == null)
        {
            removeOneChild(parent,current);
        }
        else
        {
            removeTwoChildren(current);
        }
        return current.getElement();
    }

    // # DONE !
    @Override public T removeMax() {
        TreeNode<T> parent = null;
        TreeNode<T> current = (TreeNode<T>) getRoot();

        while(current.getRightChild() != null)
        {
            parent = current;
            current = (TreeNode<T>) current.getRightChild();
        }

        if(current.getLeftChild() == null && current.getRightChild() == null)
        {
            removeLeafNode(parent,current);
        }
        else if(current.getLeftChild() == null || current.getRightChild() == null)
        {
            removeOneChild(parent,current);
        }
        else
        {
            removeTwoChildren(current);
        }
        return current.getElement();
    }

    // # DONE !
    @Override public T findMin() {
        TreeNode<T> current = (TreeNode<T>) getRoot();

        while(current.getLeftChild() != null)
        {
            current = (TreeNode<T>) current.getLeftChild();
        }


        return current.getElement();
    }

    // # DONE !
    @Override public T findMax() {
        TreeNode<T> current = (TreeNode<T>) getRoot();

        while(current.getRightChild() != null)
        {
            current = (TreeNode<T>) current.getRightChild();
        }


        return current.getElement();
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

    @Override public ArrayList inOrder() {
        return null;
    }
    @Override public ArrayList preOrder() {
        return null;
    }
    @Override public ArrayList postOrder() {
        return null;
    }
    @Override public ArrayList levelOrder() {
        return null;
    }

    // WIP
    @Override public int height() {
        if (root == null) {
            return 0;
        }
        int height = 0;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode<T> node = queue.poll();
                if (node.getLeftChild() != null) {
                    queue.offer((TreeNode<T>) node.getLeftChild());
                }
                if (node.getRightChild() != null) {
                    queue.offer((TreeNode<T>) node.getRightChild());
                }
            }
            height++;
        }
        return height;
    }
}
