package Algorithmen.sort;

import Algorithmen.comparator.Comparator;

public class InsertionSort<T> extends Swapper<T> implements Sortable<T> {
    @Override
    public void sort(T[] students, Comparator<T> comparator) {
        T temp;
        for (int i = 1; i < students.length; i++) {
            temp = students[i];
            int j = i;
            while ( j > 0 && comparator.compare(students[j-1], temp) > 0) {
                students[j] = students[j-1];
                j--;
            }
            students[j] = temp;
        }

    }
}
