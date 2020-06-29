package Algorithmen.comparator;

import Algorithmen.Student;

public class MatrNumberComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getMatriculationNumber() - o2.getMatriculationNumber();
    }
}

