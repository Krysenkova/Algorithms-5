package Algorithmen;

public class Student {
    String name;
    String prename;
    int course;
    int matriculationNumber;

    public Student(String name, String prename, int course, int matriculationNumber) {
        this.name = name;
        this.prename = prename;
        this.course = course;
        this.matriculationNumber = matriculationNumber;
    }

    public String getName() {
        return name;
    }

    public String getPrename() {
        return prename;
    }

    public int getCourse() {
        return course;
    }

    public int getMatriculationNumber() {
        return matriculationNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", prename='" + prename + '\'' +
                ", course=" + course +
                ", matriculationNumber=" + matriculationNumber +
                '}';
    }

}
