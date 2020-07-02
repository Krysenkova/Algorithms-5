package Algorithmen.sort;

import Algorithmen.comparator.Comparator;

public class Quicksort<T> extends Swapper<T> implements Sortable<T> {
    @Override
    public void sort(T[] students, Comparator<T> comparator) {
        quickSort(students, 0, students.length - 1, comparator);
    }

    public void quickSort(T[] students, int start, int end, Comparator<T> comparator) {
        int partition = partition(students, start, end, comparator);

        if (partition - 1 > start) {
            quickSort(students, start, partition - 1, comparator);
        }
        if (partition + 1 < end) {
            quickSort(students, partition + 1, end, comparator);
        }
    }

    public int partition(T[] students, int start, int end, Comparator<T> comparator) {
        T pivot = students[end];
        for (int i = start; i < end; i++) {
            if (comparator.compare(students[i], pivot) < 0) {
                swap(students, start, i);
                start++;
            }
        }

        T temp = students[start];
        students[start] = pivot;
        students[end] = temp;

        return start;
    }

}
