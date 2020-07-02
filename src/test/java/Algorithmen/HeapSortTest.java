package Algorithmen;

import Algorithmen.comparator.MatrNumberComparator;
import Algorithmen.data.Student;
import Algorithmen.sort.Bubblesort;
import Algorithmen.sort.HeapSort;
import org.junit.Assert;
import org.junit.Test;

public class HeapSortTest {
    @Test
    public void heapSortByMatNumTest() {
        var s1 = new Student("Watson", "John", 1, 3568);
        var s2 = new Student("Holmes", "Sherlock", 5, 7629);
        var s3 = new Student("Moriarty", "Jim", 3, 4321);
        Student[] students = new Student[3];
        students[0] = s3;
        students[1] = s1;
        students[2] = s2;
        HeapSort<Student> algo = new HeapSort<>();
        algo.sort(students, new MatrNumberComparator());
        Student[] actual_students = new Student[3];
        actual_students[0] = s1;
        actual_students[1] = s3;
        actual_students[2] = s2;
        Assert.assertArrayEquals(actual_students, students);
    }
}
