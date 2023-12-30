package project1.console;

import java.util.Scanner;

public class Console {
    private static Scanner scanner;

    public static String readLine() {
        return getInstance().nextLine();
    }

    private static Scanner getInstance() {
        if(scanner == null)
            scanner = new Scanner(System.in);

        return scanner;
    }
}
