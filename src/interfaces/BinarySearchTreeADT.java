package interfaces;

public interface BinarySearchTreeADT<T extends Comparable<T>> extends BinaryTreeADT
{
    void addElement(T target) throws Exception;

    T removeElement(T target) throws Exception;

    T removeMin();

    T removeMax();

    T findMin();

    T findMax();
}
