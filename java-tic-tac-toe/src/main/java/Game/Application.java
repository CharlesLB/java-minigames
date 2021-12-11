package Game;

import Game.Domain.Game;
import Game.Domain.Match;

public class Application {
    public static void main(String[] args) {
       play();
    }

    public static void play(){
        Game.selectMode();
        Game.createMatch();

        if(Game.playAgain()){
            play();
        }
    }
}
