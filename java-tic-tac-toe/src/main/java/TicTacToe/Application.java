package TicTacToe;

import TicTacToe.Domain.Game;

public class Application {
    Game game;

    public static void main(String[] args) {
       play();
    }

    public static void play(){
        Game.selectMode();
        Game.buildMatch();
        Game.startMatch();

        if(Game.playAgain()){
            play();
        }
    }
}
