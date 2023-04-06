package code;

import interfaces.BinarySearchTreeADT;
import interfaces.BinaryTreeNodeADT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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


        size--;
        return (T) current.getElement();
    }

    // ! Remove Leaf node
    private void removeLeafNode(TreeNode<T> parent, TreeNode<T> nodeToRemove) {
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
    private void removeOneChild(TreeNode<T> parent, TreeNode<T> nodeToRemove) {
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
    private void removeTwoChildren(TreeNode<T> nodeToRemove) {
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

    @Override public boolean contains(Comparable element)
    {
        // ! Check if tree has elements
        if(isEmpty())
        {
            // # If not, it doesn't contain anything.
            return false;
        }


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

    @Override public T removeMin() {
        // ! Check if tree is empty --> RETURN NULL!
        if(isEmpty())
        {
            return null;
        }

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

    @Override public T removeMax() {
        // ! Check if tree is empty --> RETURN NULL!
        if(isEmpty())
        {
            return null;
        }

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

    @Override public T findMin() {
        // ! Check if tree is empty --> RETURN NULL!
        if(isEmpty())
        {
            return null;
        }

        TreeNode<T> current = (TreeNode<T>) getRoot();

        while(current.getLeftChild() != null)
        {
            current = (TreeNode<T>) current.getLeftChild();
        }


        return current.getElement();
    }

    @Override public T findMax() {

        // ! Check if tree is empty --> RETURN NULL!
        if(isEmpty())
        {
            return null;
        }
        TreeNode<T> current = (TreeNode<T>) getRoot();

        while(current.getRightChild() != null)
        {
            current = (TreeNode<T>) current.getRightChild();
        }


        return current.getElement();
    }

    @Override public BinaryTreeNodeADT getRoot() {
        return root;
    }

    @Override public void setRoot(BinaryTreeNodeADT node) {
        this.root = (TreeNode) node;
    }

    @Override public boolean isEmpty() {
        return root == null;
    }

    @Override public int size() {
        return size;
    }

    @Override public ArrayList inOrder() {
        ArrayList<T> inOrder = new ArrayList<>(); // # Start the list.
        inOrderHelper(root, inOrder);
        return inOrder;
    }

    // * HELPER METHOD
    private void inOrderHelper(TreeNode<T> node, ArrayList<T> result) {
        if(node != null)
        {
            inOrderHelper((TreeNode<T>) node.getLeftChild(),result); // # Continue from left child
            result.add(node.getElement()); // * Add self to the result list.
            inOrderHelper((TreeNode<T>) node.getRightChild(),result); // # Continue from right child
        }

    }

    @Override public ArrayList preOrder() {
        ArrayList<T> preOrder = new ArrayList<>(); // # Start the list.
        preOrderHelper(root, preOrder);
        return preOrder;
    }
    // * HELPER METHOD
    private void preOrderHelper(TreeNode<T> node, ArrayList<T> result) {
        if(node != null)
        {
            preOrderHelper((TreeNode<T>) node.getRightChild(),result); // # Continue from right child
            result.add(node.getElement()); // * Add self to the result list.
            preOrderHelper((TreeNode<T>) node.getLeftChild(),result); // # Continue from left child

        }
    }

    @Override public ArrayList postOrder()
    {
        ArrayList<T> postOrder = new ArrayList<>(); // # Start the list
        postOrderHelper(root, postOrder);
        return postOrder;
    }
    // * HELPER METHOD
    private void postOrderHelper(TreeNode<T> node, ArrayList<T> result)
    {
        if(node != null)
        {
            postOrderHelper((TreeNode<T>) node.getLeftChild(),result); // # Continue from left child
            postOrderHelper((TreeNode<T>) node.getRightChild(), result); // # Continue from right child
            result.add(node.getElement()); // * Add self to the result list.
        }
    }

    @Override public ArrayList levelOrder()
    {
        ArrayList<T> levelOrder = new ArrayList<>();
        levelOrderHelper(root,levelOrder);
        return levelOrder;
    }
    // * HELPER METHOD
    private void levelOrderHelper(TreeNode<T> node, ArrayList<T> result)
    {
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty())
        {
            TreeNode<T> dequeued = queue.poll(); // * Take out a node from the queue.
            // # Check for children.
            if(dequeued.getLeftChild() != null)
            {
                queue.offer((TreeNode<T>) dequeued.getLeftChild());
            }
            if(dequeued.getRightChild() != null)
            {
                queue.offer((TreeNode<T>) dequeued.getRightChild());
            }
            result.add(dequeued.getElement()); // * Add it to the result list
        }
    }

    @Override public int height()
    {
        // ! Check if Root is null --> Height = 0!
        if (root == null)
        {
            return 0;
        }

        // # Height initialized
        int height = 0;

        // * Make a queue to store all the nodes
        Queue<TreeNode<T>> queue = new LinkedList<>();
        // * Start by adding Root to the queue.
        queue.offer(root);

        // ¤ Start count the height
        while (!queue.isEmpty())
        {
            // # Levelsize stores the number of nodes in the queue at each level.
            int levelSize = queue.size();
            // * Loop through all the nodes in the queue.
            for (int i = 0; i < levelSize; i++)
            {
                // # Take out a node from the queue.
                TreeNode<T> node = queue.poll();
                // # Has left child?
                if (node.getLeftChild() != null)
                {
                    // * Add the child to the queue!
                    queue.offer((TreeNode<T>) node.getLeftChild());
                }
                // # Has right child?
                if (node.getRightChild() != null)
                {
                    // * Add the child to the queue
                    queue.offer((TreeNode<T>) node.getRightChild());
                }
            }
            // ! Increase the height by 1
            height++;
        }
        // # Return the counted height.
        return height;
    }

    // ! REBALANCE METHOD
    public void rebalance()
    {
        if(isEmpty())
        {
            // * Tree is empty, nothing to rebalance
            return;
        }

        List<TreeNode<T>> nodes = new ArrayList<>(); // # Used to store the nodes
        storeBTSNodes(root,nodes); // # Balance then tree

        root = buildTreeUtil(nodes,0,nodes.size()-1);
    }

    // * HELPER METHOD
    private void storeBTSNodes(TreeNode<T> node, List<TreeNode<T>> nodes)
    {
        // ! Is NULL?
        if(node == null)
        {
            return; // ! If node is null, stop.
        }

        storeBTSNodes((TreeNode<T>) node.getLeftChild(),nodes); // # Store the left side
        nodes.add(node); // * Store self
        storeBTSNodes((TreeNode<T>) node.getRightChild(),nodes); // # Store the right side
    }

    // * HELPER METHOD
    private TreeNode<T> buildTreeUtil(List<TreeNode<T>> nodes, int start, int end)
    {
        // # Check if the start index is greater than the end index
        if(start > end)
        {
            // ! If it is, return null as something went wrong
            return null;
        }

        // # Find the middle index between the start and end index
        int mid = (start + end)/2;

        // # Create a new tree node with the value at the middle index
        TreeNode<T> node = nodes.get(mid);

        // * Recursively build the left subtree of the new node
        node.addLeftChild(buildTreeUtil(nodes, start, mid-1));

        // * Recursively build the right subtree of the new node
        node.addRightChild(buildTreeUtil(nodes, mid+1, end));

        return node; // # Return the new tree node with the built subtrees
    }
}
