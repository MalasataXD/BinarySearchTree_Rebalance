package test;

import code.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeTest
{
    private TreeNode node;

    // # SETTER & GETTER TEST
    @Test
    public void getElementFromCreation() {
        // # ARRANGE & ACT
        node = new TreeNode(1);

        // # ASSERT
        assertEquals(1,node.getElement());
    }
    @Test public void setElementOnceAndRetrieve() {
        // # ARRANGE
        node = new TreeNode(1);

        // # ACT
        node.setElement(2);

        // # ASSERT
        assertEquals(2,node.getElement());
    }
    @Test public void setElementMultipleAndRetrieve() {
        // # ARRANGE
        node = new TreeNode(1);

        // # ACT
        node.setElement(2);
        node.setElement(3);
        node.setElement(4);
        node.setElement(5);

        // # ASSERT
        assertEquals(5,node.getElement());
    }

    // # LEFT CHILD TESTS
    @Test public void checkInitialValueOfLeftChild() {
        // # ARRANGE & ACT
        node = new TreeNode(1);

        // # ASSERT
        assertEquals(null,node.getLeftChild());
    }
    @Test public void setLeftChildOnceAndCheckValueIsRight(){
        // # ARRANGE
        node = new TreeNode(1);
        TreeNode<Integer> child = new TreeNode<>(2);

        // # ACT
        node.addLeftChild(child);

        // # ASSERT
        assertEquals(2,node.getLeftChild().getElement());
    }
    @Test public void setLeftChildMultipleTimesAndCheckValueIsRight(){
        // # ARRANGE
        node = new TreeNode(1);
        TreeNode<Integer> one = new TreeNode<>(2);
        TreeNode<Integer> two = new TreeNode<>(3);
        TreeNode<Integer> three = new TreeNode<>(4);
        TreeNode<Integer> four = new TreeNode<>(5);
        TreeNode<Integer> five = new TreeNode<>(6);

        // # ACT
        node.addLeftChild(one);
        node.addLeftChild(two);
        node.addLeftChild(three);
        node.addLeftChild(four);
        node.addLeftChild(five);

        // # ASSERT
        assertEquals(6,node.getLeftChild().getElement());
    }

    // # RIGHT CHILD TESTS
    @Test public void checkInitialValueOfRightChild() {
        // # ARRANGE & ACT
        node = new TreeNode(1);

        // # ASSERT
        assertEquals(null,node.getRightChild());
    }
    @Test public void setRightChildOnceAndCheckValueIsRight(){
        // # ARRANGE
        node = new TreeNode(1);
        TreeNode<Integer> child = new TreeNode<>(2);

        // # ACT
        node.addRightChild(child);

        // # ASSERT
        assertEquals(2,node.getRightChild() .getElement());
    }
    @Test public void setRightChildMultipleTimesAndCheckValueIsRight(){
        // # ARRANGE
        node = new TreeNode(1);
        TreeNode<Integer> one = new TreeNode<>(2);
        TreeNode<Integer> two = new TreeNode<>(3);
        TreeNode<Integer> three = new TreeNode<>(4);
        TreeNode<Integer> four = new TreeNode<>(5);
        TreeNode<Integer> five = new TreeNode<>(6);

        // # ACT
        node.addRightChild(one);
        node.addRightChild(two);
        node.addRightChild(three);
        node.addRightChild(four);
        node.addRightChild(five);

        // # ASSERT
        assertEquals(6,node.getRightChild().getElement());
    }

    // # COMPARE NODES TEST
    @Test public void CompareToNodeWithLowerValue() {
        // # ARRANGE
        TreeNode<Integer> node = new TreeNode<>(0);
        TreeNode<Integer> comparableNode = new TreeNode<>(-1);
        int compared = node.compareTo(comparableNode.getElement());

        // # ACT & ASSERT
        assertEquals(1,compared);
    }
    @Test public void CompareToSelf() {
        // # ARRANGE
        TreeNode<Integer> node = new TreeNode<>(0);
        int compared = node.compareTo(node.getElement());

        // # ACT & ASSERT
        assertEquals(0,compared);
    }
    @Test public void CompareToEqualNode() {
        // # ARRANGE
        TreeNode<Integer> node = new TreeNode<>(0);
        TreeNode<Integer> comparableNode = new TreeNode<>(0);
        int compared = node.compareTo(comparableNode.getElement());

        // # ACT & ASSERT
        assertEquals(0,compared);
    }
    @Test public void CompareToNodeWithBiggerValue() {
        // # ARRANGE
        TreeNode<Integer> node = new TreeNode<>(0);
        TreeNode<Integer> comparableNode = new TreeNode<>(1);
        int compared = node.compareTo(comparableNode.getElement());

        // # ACT & ASSERT
        assertEquals(-1,compared);
    }

}
