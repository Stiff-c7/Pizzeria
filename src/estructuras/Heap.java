package estructuras;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap<T extends Comparable<T>> implements IHeap<T> {
    private List<T> heap;
    private Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    @Override
    public void insert(T value) {
        heap.add(value);
        swim(heap.size() - 1);
    }

    @Override
    public T remove() {
        if (heap.isEmpty()) return null;
        T root = heap.get(0);
        exch(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        sink(0);
        return root;
    }

    @Override
    public T peek() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public ArrayList<T> getList() {
        return new ArrayList<>(heap);
    }

    private void swim(int index) {
        while (index > 0 && compare(index, parent(index)) > 0) {
            exch(index, parent(index));
            index = parent(index);
        }
    }

    private void sink(int index) {
        int n = heap.size();
        while (left(index) < n) {
            int j = left(index);
            if (right(index) < n && compare(right(index), j) > 0) {
                j = right(index);
            }
            if (compare(index, j) >= 0) break;
            exch(index, j);
            index = j;
        }
    }
    //private void sink(int index) {
      //  int left = left(index);
        //int right= right(index);
        //int largest = index;

        //if (left < heap.size() && compare(heap.get(left), heap.get(largest)) > 0) {
          //  largest = left;
        //}
        //if (right < heap.size() && compare(heap.get(right), heap.get(largest)) > 0) {
          //  largest = right;
        //}
        //if (largest != index) {
          //  exch(index, largest);
            //sink(largest);
        

    private int compare(int i, int j){
        return comparator.compare(heap.get(i), heap.get(j));
    }


    private void exch(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }
    
}
