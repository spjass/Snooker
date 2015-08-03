package spjass.snooker;

import java.util.ArrayList;

/**
 * Created by b703920 on 4.6.2015.
 */
public class Game {

    protected ArrayList<Player> playerList;
    protected Player playerInTurn;
    protected PlayEvent lastPlayedEvent;

    public Game() {
        playerList = new ArrayList<>();
        Player player1 = new Player();
        Player player2 = new Player();
        player1.setName("Player 1");
        player2.setName("Player 2");
        playerInTurn = player1;
        playerList.add(player1);
        playerList.add(player2);
        lastPlayedEvent = (new PlayEvent(player1, 0));
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public Player getPlayerInTurn() {
        return playerInTurn;
    }

    public void setPlayerInTurn(Player playerInTurn) {
        this.playerInTurn = playerInTurn;
    }

    public PlayEvent getLastPlayedEvent() {
        return lastPlayedEvent;
    }

    public void setLastPlayedEvent(PlayEvent lastPlayedEvent) {
        this.lastPlayedEvent = lastPlayedEvent;
    }
}
