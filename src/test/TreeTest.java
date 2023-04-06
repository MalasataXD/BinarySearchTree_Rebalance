package test;

import code.BinarySearchTree;
import code.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest
{
    private BinarySearchTree<Integer> tree;

    // # SIZE
    @Test public void SizeWithoutElements() {
        // # ARRANGE
        tree = new BinarySearchTree<>();

        // # ACT & ASSERT
        assertEquals(0,tree.size());
    }

    // # ADD ELEMENT
    @Test(expected = Exception.class) public void addNULLFromTree() throws Exception {
        // # ACT & ASSERT
        tree.addElement(null);
    }
    @Test public void AddOneElement() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(1);

        // # ACT & ASSERT
        assertEquals(1,tree.size());
    }
    @Test public void AddMultipleElement() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(1);
        tree.addElement(2);
        tree.addElement(3);
        tree.addElement(4);
        tree.addElement(5);

        // # ACT & ASSERT
        assertEquals(5,tree.size());
    }

    // # REMOVE ELEMENT
    @Test(expected = Exception.class) public void removeNULLFromTree() throws Exception {
        // # ACT & ASSERT
        tree.removeElement(null);
    }
    @Test public void removeOneElementAndCheckSize() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(1);
        tree.removeElement(1);

        // # ACT & ASSERT
        assertEquals(0,tree.size());
    }
    @Test public void removeMultipleElementsAndCheckSize() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(1);
        tree.addElement(2);
        tree.addElement(3);
        tree.addElement(4);
        tree.addElement(5);
        tree.removeElement(1);
        tree.removeElement(2);

        // # ACT & ASSERT
        assertEquals(3,tree.size());
    }

    // # IS EMPTY
    @Test public void IsEmptyWithEmptyTree() {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        // # ACT & ASSERT
        assertTrue(tree.isEmpty());
    }
    @Test public void IsEmptyWithOneNode() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(1);
        // # ACT & ASSERT
        assertFalse(tree.isEmpty());
    }
    @Test public void IsEmptyWithMultipleNode() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(1);
        tree.addElement(2);
        tree.addElement(3);
        tree.addElement(4);
        tree.addElement(5);
        // # ACT & ASSERT
        assertFalse(tree.isEmpty());
    }

    // # CONTAINS
    @Test public void ContainsOneInTreeWithoutElements() {
        // # ARRANGE
        tree = new BinarySearchTree<>();

        // # ACT & ASSERT
        assertFalse(tree.contains(1));
    }
    @Test public void ContainsOneInTreeWithOnlyOne() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(1);

        // # ACT & ASSERT
        assertFalse(tree.contains(1));
    }
    @Test public void ContainsOneInTreeWithElementsButNOTOne() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(2);
        tree.addElement(3);
        tree.addElement(4);
        tree.addElement(5);

        // # ACT & ASSERT
        assertFalse(tree.contains(1));
    }
    @Test public void ContainsOneInTreeWithElementsAndOne() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(1);
        tree.addElement(2);
        tree.addElement(3);
        tree.addElement(4);
        tree.addElement(5);

        // # ACT & ASSERT
        assertTrue(tree.contains(1));
    }

    // # MIN - FIND & REMOVE
    @Test public void findMinInTreeWithNoElements() {
        // # ARRANGE
        tree = new BinarySearchTree<>();

        // # ACT &ASSERT
        assertNull(tree.findMin());
    }
    @Test public void findMinInTreeWithOneElement() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(5);
        // # ACT
        int min = tree.findMin();
        // # ASSERT
        assertEquals(5,min);
    }
    @Test public void findMinInTreeWithMultipleElements() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(5);
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(2);
        tree.addElement(4);
        tree.addElement(1);
        tree.addElement(6);
        tree.addElement(9);

        // # ACT
        int min = tree.findMin();
        // # ASSERT
        assertEquals(1,min);
    }
    @Test public void removeMinAndCheckSize() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(5);
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(2);
        tree.addElement(4);
        tree.addElement(1);
        tree.addElement(6);
        tree.addElement(9);

        // # ACT & ASSERT
        tree.removeMax();
        assertFalse(tree.contains(1));
    }

    // # MAX - FIND & REMOVE
    @Test public void findMaxInTreeWithNoElements() {
        // # ARRANGE
        tree = new BinarySearchTree<>();

        // # ACT &ASSERT
        assertNull(tree.findMax());
    }
    @Test public void findMaxInTreeWithOneElement() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(5);
        // # ACT
        int max = tree.findMax();
        // # ASSERT
        assertEquals(5,max);
    }
    @Test public void findMaxInTreeWithMultipleElements() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(5);
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(2);
        tree.addElement(4);
        tree.addElement(1);
        tree.addElement(6);
        tree.addElement(9);

        // # ACT
        int max = tree.findMax();
        // # ASSERT
        assertEquals(9,max);
    }
    @Test public void removeMaxAndCheckSize() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(5);
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(2);
        tree.addElement(4);
        tree.addElement(1);
        tree.addElement(6);
        tree.addElement(9);

        // # ACT & ASSERT
        tree.removeMax();
        assertFalse(tree.contains(9));
    }

    // # HEIGHT
    @Test public void heightWithEmptyTree() {
        // # ARRANGE
        tree = new BinarySearchTree<>();

        // # ACT & ASSERT
        assertEquals(0, tree.height());
    }
    @Test public void heightWithOneNode() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(1);

        // # ACT & ASSERT
        assertEquals(1, tree.height());
    }
    @Test public void heightWithMultipleNodes() throws Exception {
        // # ARRANGE
        tree = new BinarySearchTree<>();
        tree.addElement(5);
        tree.addElement(3);
        tree.addElement(7);
        tree.addElement(2);
        tree.addElement(4);
        tree.addElement(1);
        tree.addElement(6);
        tree.addElement(9);

        // # ACT & ASSERT
        assertEquals(4, tree.height());
    }

    // # ROOT - SETTER AND GETTER
    @Test public void setRootToNULL() {
        // # ARRANGE
        tree = new BinarySearchTree<>();

        // # ACT
        tree.setRoot(null);

        // # ASSERT
        assertNull(tree.getRoot());
    }
    @Test public void setRootOnce() {
        // # ARRANGE
        tree = new BinarySearchTree<>();

        // # ACT
        tree.setRoot(new TreeNode(1));

        // # ASSERT
        assertEquals(1,tree.getRoot().getElement());
    }
    @Test public void setRootMultipleTimes() {
        // # ARRANGE
        tree = new BinarySearchTree<>();

        // # ACT
        tree.setRoot(new TreeNode(1));
        tree.setRoot(new TreeNode(2));
        tree.setRoot(new TreeNode(3));
        tree.setRoot(new TreeNode(4));
        tree.setRoot(new TreeNode(5));

        // # ASSERT
        assertEquals(5,tree.getRoot().getElement());
    }


    // TODO: REBALANCE TEST

    // TODO: TRAVERSAL TEST


}
