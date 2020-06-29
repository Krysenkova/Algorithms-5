package Algorithmen.menu;

import java.util.Scanner;

public class Console {

    public static int readIntFromStdin(String text) {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println(text);
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
            return number;
        } else
            return readIntFromStdin(scanner.next() + " is not a number. Try again!");
    }
}
