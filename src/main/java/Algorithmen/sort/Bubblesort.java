package Algorithmen.sort;

import Algorithmen.comparator.Comparator;

public class Bubblesort<T> extends Swapper<T> implements Sortable<T> {
    @Override
    public void sort(T[] students, Comparator<T> comparator) {
        for (int i = 1; i < students.length; i++) {
            for (int e = 0; e < students.length - i; e++) {
                if (comparator.compare(students[e], students[e + 1]) > 0) {
                    swap(students, e, e + 1);
                }
            }
        }
    }
}
