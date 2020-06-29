package Algorithmen.sort;

import Algorithmen.comparator.Comparator;

public class HeapSort<T> extends Swapper<T> implements Sortable<T> {

    @Override
    public void sort(T[] students, Comparator<T> comparator) {
        int n = students.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(students, n, i, comparator);
        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(students, 0, i);
            // call max heapify on the reduced heap
            heapify(students, i, 0, comparator);
        }
    }

    void heapify(T[] students, int n, int i, Comparator<T> comparator) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && comparator.compare(students[l], students[largest]) > 0){
            largest = l;}

        // If right child is larger than largest so far
        if (r < n && comparator.compare(students[r], students[largest]) > 0){
            largest = r;}

        // If largest is not root
        if (largest != i) {
            swap(students, i , largest);

            // Recursively heapify the affected sub-tree
            heapify(students, n, largest, comparator);
        }
    }
}
