import code.BinarySearchTree;
import code.BinaryTreePrint;
import code.TreeNode;

public class Main {
    public static void main(String[] args) throws Exception {
        // ¤ PRINTER
        BinaryTreePrint printer = new BinaryTreePrint();
        // # TREE
        BinarySearchTree<Integer> integerTree = new BinarySearchTree<>();
        System.out.println("[RUNNING]");
        System.out.println("ISEMPTY (0 elements): " + integerTree.isEmpty());
        // * TEST
        integerTree.addElement(5);
        integerTree.addElement(3);
        integerTree.addElement(7);
        integerTree.addElement(2);
        integerTree.addElement(4);
        integerTree.addElement(1);
        integerTree.addElement(6);
        integerTree.addElement(9);
        System.out.println("SIZE: " + integerTree.size());
        System.out.println("ISEMPTY: " + integerTree.isEmpty());
        System.out.println("CONTAINS 2: " + integerTree.contains(2));
        System.out.println("HEIGHT: " + integerTree.height());
        printer.printTree((TreeNode) integerTree.getRoot());




    }
}