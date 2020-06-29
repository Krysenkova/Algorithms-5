package Algorithmen.sort;

public class Swapper<T> {
    protected void swap(T[] students, int i, int j){
        T memorizedObject = students[i];
        students[i] = students[j];
        students[j] = memorizedObject;
    }
}
