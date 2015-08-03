package spjass.snooker;

/**
 * Created by b703920 on 4.6.2015.
 */
public class PlayEvent {
    private String playStr;
    private Player player;
    private int points;

    public PlayEvent(Player player, int points) {
        this.player = player;
        playStr = player.getName() + ": " + points + " points added";
    }

    public String getPlayStr() {
        playStr = player.getName() + ": " + points + " points added";
        return playStr;
    }

    public void setPlayStr(String playStr) {
        this.playStr = playStr;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void undo() {
        player.addPoints(points * (-1));
    }

    public void play() {
        player.addPoints(points);
    }
}
