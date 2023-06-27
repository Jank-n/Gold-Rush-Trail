package goldrushtrail;

public class Player extends GoldRushTrail{
	
	//base attributes for occupations
	int currentLevel;
	int currentEnergy;
	int currentMoney;
	int currentAmmo;
	int currentWagonPart;
	int currentFurs;
	
	
	//constructor
	public Player() {
		
	}
	//setters and getters
	//level
	public int getLevel() {
		return currentLevel;
	}
	public void setLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
	//energy
	public int getEnergy() {
		return currentEnergy;
	}
	public void setenergy(int currentEnergy) {
		this.currentEnergy = currentEnergy;
	}
	//money
	public double getMoney() {
		return currentMoney;
	}
	public void setMoney(int currentMoney) {
		this.currentMoney = currentMoney;
	}
	//ammo
	public int getAmmo() {
		return currentAmmo;
	}
	public void setAmmo(int currentAmmo) {
		this.currentAmmo = currentAmmo;
	}
	//wagon part
	public int getWagonPart(){
		return currentWagonPart;
	}
	public void setWagonParts(int currentWagonPart) {
		this.currentWagonPart = currentWagonPart;
	}
	//furs
	public int getFurs() {
		return currentFurs;
	}
	public void setFurs(int currentFurs) {
		this.currentFurs = currentFurs;
	}
	
	public void printDetails() {
		System.out.println("Current inventory of your resources:\n");
		System.out.println("You have " + currentEnergy + " energy. You will need to rest from time to time to keep your energy up. If you hit zero, you will perish in the wild.");
		System.out.println("Currently have $" + currentMoney + " in your wallet. Buy supplies in settlements along your journey");
		System.out.println("Your family rifle has " + currentAmmo + " bullets. Never know what you might find in the country.");
		System.out.println(currentWagonPart + " spare wagon parts to repair your wagon.");
		System.out.println("Finally, you have " + currentFurs + " furs in the wagon if you need to make trades.\n");
		
	}
		
}


