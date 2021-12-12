package TicTacToe.UserUtilities;

import TicTacToe.Domain.Match;

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

    public static void startMatch(Match match){
        System.out.println("Let's Play Tic Tac Toe!");
        System.out.println(match.getPlayer1().getName() + ": " + match.getPlayer1().getSymbol());

        switch (match.getMode()){
            case "pve":
                System.out.println("Bot:" + match.getBot().getSymbol());
                return;
            case "pvp":
                System.out.println(match.getPlayer2().getName() + ": " + match.getPlayer2().getSymbol());
                return;
            default: applicationError("Invalid Game Mode");
        }
    }

    // errors

    public static void listenerError() {
        System.out.println("The value inserted is not valid \n");
    }

    public static void playerDataError(String data) {
        System.out.println("Invalid data: " + data);
        System.out.println("Try Again");
    }

    public static void applicationError(String message) {
        System.out.println("Application Error:" + message + "\n");
    }
}
