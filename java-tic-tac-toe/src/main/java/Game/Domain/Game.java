package Game.Domain;

import Game.Players.Player;
import Game.UserUtilities.Listener;
import Game.UserUtilities.Printer;

public class Game {
    private static Match match;

    public Game(Match match) {
        this.match = match;
    }

    public static void selectMode(){
        Printer.selectMode();
        int modeId = Listener.getInt();
        String matchMode = Match.getModeById(modeId);

        if(matchMode == null){
            Printer.listenerError();
            selectMode();
            return;
        }

        match.setMode(matchMode);
    }

    public static void createMatch(){
        switch (match.getMode()){
            case "pvp": return;
            case "pve": return;
        }
    }

    private  

    private static void createPlayer(int playerNumber){
        Printer.getPlayerData(playerNumber,"name");
        String playerName = Listener.getString();

        Printer.getPlayerData(playerNumber,"symbol");
        char playerSymbol = Listener.getChar();

        Player player = new Player(playerName, playerSymbol);

        if (playerNumber == 1){
            match.setPlayer1(player);
            return;
        }

        match.setPlayer2(player);
    }

    public static boolean playAgain(){
        Printer.playAgain();
        int playAgainCode = Listener.getInt();

        if(playAgainCode != 0 && playAgainCode != 1){
            Printer.listenerError();
            return  playAgain();
        }

        return playAgainCode == 1;
    }

}
