package interfaces;

public interface BinarySearchTreeADT<T> extends BinaryTreeADT
{
    void addElement(T target);

    T removeElement(T target);

    T removeMin();

    T removeMax();

    T findMin();

    T findMax();


}
