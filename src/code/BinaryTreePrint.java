package code;

import java.util.ArrayList;

public class BinaryTreePrint
{
    TreeNode<Integer> root;

    /*
     * This method requires that there is a class BinaryTreeNode
     * and that the field "root" is initialized
     * as well as methods to set and get nodes and values:
     * E getElement() // return the element stored in the node
     * (integers can be used directly used due to javas autoboxing unboxing
     * BinaryTreeNode getLeftChild()) // return a reference to leftChild
     * BinaryTreeNode getRightChild()) // return a reference to rightChild
     *
     * The tree must be created elsewhere (possible in a Main or Test class).
     */

    public void printTree(TreeNode root) {
        ArrayList<TreeNode> parent = new ArrayList<>();
        parent.add(root);
        printT(parent, 64);
    }

    private void printT(ArrayList<TreeNode> parent, int left) {
        ArrayList<TreeNode> children = new ArrayList<TreeNode>();
        TreeNode<Integer> current;
        boolean moreNodes = false;
        boolean firstNode = true;
        TreeNode<Integer> dummy = new TreeNode(0);

        int dist = 0;
        System.out.println();
        System.out.println();

        while (!parent.isEmpty()) {
            current = parent.remove(0);

            if (firstNode) {
                printSpace(left);
                if (current.getElement() != 0)
                    System.out.print(current.getElement());
                dist = 2 * left;
                firstNode = false;

                if (current.getElement() != 0) {
                    if (current.getLeftChild() != null) {
                        children.add((TreeNode) current.getLeftChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                    if (current.getRightChild() != null) {
                        children.add((TreeNode) current.getRightChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                } else {
                    children.add(dummy);
                    children.add(dummy);
                }
            } else {
                if (current.getElement() != 0) {
                    printSpace(dist - 1);
                    System.out.print(current.getElement());
                    if (current.getLeftChild() != null) {
                        children.add((TreeNode) current.getLeftChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                    if (current.getRightChild() != null) {
                        children.add((TreeNode) current.getRightChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                } else {
                    printSpace(dist - 1);
                    System.out.print(" ");
                    children.add(dummy);
                    children.add(dummy);
                }
            }
        }

        if (moreNodes)
            printT(children, left / 2);

    }

    private void printSpace(int pos) {
        for (int i = 0; i < pos; i++)
            System.out.print(" ");

    }


}
