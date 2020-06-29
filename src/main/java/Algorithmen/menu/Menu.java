package Algorithmen.menu;

import Algorithmen.main.ADSHashTable;
import Algorithmen.main.HashInvoker;

public class Menu {
    public static void mainMenu() {
        System.out.println();
        System.out.println("Console-Application: Exercise-5             <Ekaterina><Krysenkova><573734>");
        System.out.println();
        System.out.println("1.Add a number to hash table");
        System.out.println("2.Get a number from hash table");
        System.out.println("3.Search for a number in hash table");
        System.out.println("4.Delete a number from hash table");
        System.out.println("5.Clear the hash table");
        System.out.println("6.Sort students by matriculation number");
        System.out.println("0.Exit");
        System.out.println();
    }


    public static void choice(ADSHashTable table) {
        int choice = 1;
        int input;
        while (choice != 0) {
            mainMenu();
            choice = Console.readIntFromStdin("Please enter a number for an option: ");
            switch (choice) {
                case 1:
                    input = Console.readIntFromStdin("Please enter a number for adding: ");
                    HashInvoker.insert(table, input);
                    break;
                case 2:

                case 3:
                    input = Console.readIntFromStdin("Please enter a number for searching: ");
                    HashInvoker.search(table, input);
                    break;
                case 4:
                    input = Console.readIntFromStdin("Please enter a number for deleting: ");
                    HashInvoker.remove(table, input);
                    break;
                case 5:
                    HashInvoker.clear(table);
                    break;
                case 6:
                    SortMenu.executeSortMenu();
                case 0:
                    break;
                default:
                    System.out.println("Wrong input. Try again!");


            }
        }
    }
}
