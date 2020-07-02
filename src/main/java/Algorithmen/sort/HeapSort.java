package Algorithmen.sort;

import Algorithmen.comparator.Comparator;

public class HeapSort<T> extends Swapper<T> implements Sortable<T> {

    @Override
    public void sort(T[] students, Comparator<T> comparator) {
        int n = students.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(students, n, i, comparator);
        }
        for (int i = n - 1; i > 0; i--) {
            swap(students, 0, i);
            heapify(students, i, 0, comparator);
        }
    }

    void heapify(T[] students, int n, int i, Comparator<T> comparator) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && comparator.compare(students[l], students[largest]) > 0) {
            largest = l;
        }
        if (r < n && comparator.compare(students[r], students[largest]) > 0) {
            largest = r;
        }
        if (largest != i) {
            swap(students, i, largest);
            heapify(students, n, largest, comparator);
        }
    }
}
