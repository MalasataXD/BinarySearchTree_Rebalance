package interfaces;

public interface BinarySearchTreeADT<T> extends BinaryTreeADT
{
    void addElement(T target) throws Exception;

    T removeElement(T target);

    T removeMin();

    T removeMax();

    T findMin();

    T findMax();


}
