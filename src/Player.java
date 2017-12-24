import java.io.Serializable;

public class Player implements Serializable{
 private String name;
 private int money;
 
	 public Player(String name,int money) {
		   this.name = name;
		   this.money = money;
	 }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Player [name=" + name + ", money=" + money + "]";
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
