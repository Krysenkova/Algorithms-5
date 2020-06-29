package Algorithmen.sort;

import Algorithmen.Student;
import Algorithmen.comparator.Comparator;


public interface Sortable<T> {
    void sort(T[] students, Comparator<T> comparator);
}
