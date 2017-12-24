import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
	
private ArrayList<Player> players;
private int bankCount;

public Game(int bankCount)
{
	this.bankCount = bankCount;
	players = new ArrayList<>();
}

public ArrayList<Player> getPlayers() {
	return players;
}

public void setPlayers(ArrayList<Player> players) {
	this.players = players;
}

public int getBankCount() {
	return bankCount;
}

@Override
public String toString() {
	return "Game [players=" + players + ", bankCount=" + bankCount + "]";
}

public void setBankCount(int bankCount) {
	this.bankCount = bankCount;
}

}
