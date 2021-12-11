package Game.UserUtilities;

public class Printer {
    public static void selectMode() {
        System.out.println("Choose game mode:");
        System.out.println("  [0]: Player vs Player");
        System.out.println("  [1]: Player vs Bot");
    }

    public static void getPlayerData(int player, String data) {
        System.out.println("Insert Player" + player + " " + data);
    }

    public static void playAgain() {
        System.out.println("Do you want play again? (S/N)");
        System.out.println("  [0]: Yes");
        System.out.println("  [1]: No");
    }

    // errors

    public static void listenerError() {
        System.out.println("The value inserted is not valid \n");
    }
}
