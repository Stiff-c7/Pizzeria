package estructuras;

import java.util.ArrayList;

public interface IHeap<T> {
    void insert(T value);
    T remove();
    T peek();
    boolean isEmpty();
    int size();
    ArrayList<T> getList();
}
