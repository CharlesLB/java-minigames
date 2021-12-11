package Game.Domain;

import Game.Players.Bot;
import Game.Players.Player;

public class Match {
    private String mode;
    private Player player1;
    private Player player2;
    private Bot bot;
    private Board board;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public static String getModeById(int modeId){
        switch (modeId){
            case 0: return "pvp";
            case 1: return "pve";
            default: return null;
        }
    }
}
