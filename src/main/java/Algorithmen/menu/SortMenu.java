package Algorithmen.menu;

import Algorithmen.Student;
import Algorithmen.comparator.MatrNumberComparator;
import Algorithmen.main.App;
import Algorithmen.sort.Bubblesort;
import Algorithmen.sort.HeapSort;
import Algorithmen.sort.InsertionSort;
import Algorithmen.sort.Quicksort;

public class SortMenu {
    public static void sortMenu() {
        System.out.println("Choose a sorting algorithm:");
        System.out.println("1.Insertion sort");
        System.out.println("2.Heap sort");
        System.out.println("3.Bubble sort");
        System.out.println("4.Quicksort");
        System.out.println("0.Back to main menu");
        System.out.println();
    }

    public static void executeSortMenu() {
        Student[] students = App.getListOfStudents();
        System.out.println("Initial array of students:");
        App.print(students);
        System.out.println();
        int choice = 1;
        while (choice != 0) {
            sortMenu();
            choice = Console.readIntFromStdin("Please enter a number of a preferred algorithm: ");
            switch (choice) {
                case 1:
                    App.sortAndPrint(students, new InsertionSort<>(),new MatrNumberComparator());
                    break;
                case 2:
                    App.sortAndPrint(students, new HeapSort<>(),new MatrNumberComparator());
                    break;
                case 3:
                    App.sortAndPrint(students, new Bubblesort<>(),new MatrNumberComparator());
                    break;
                case 4:
                    App.sortAndPrint(students, new Quicksort<>(),new MatrNumberComparator());
                case 0:
                   break;
                default:
                    System.out.println("Wrong input. Try again!");

            }
        }
    }}
