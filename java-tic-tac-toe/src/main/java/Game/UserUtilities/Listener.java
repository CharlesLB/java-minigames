package Game.UserUtilities;

import java.util.Scanner;

public class Listener {
    private static Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        try {
            int value = scanner.nextInt();
            scanner.nextLine();
            return value;

        } catch (Exception err) {
            return getInt();
        }
    }

    public static char getChar() {
        try {
            char value = scanner.next().charAt(0);
            scanner.nextLine();
            return value;

        } catch (Exception err) {
            return getChar();
        }
    }

    public static String getString() {
        try {
            String value = scanner.nextLine();
            scanner.nextLine();
            return value;

        } catch (Exception err) {
            return getString();
        }
    }
}
