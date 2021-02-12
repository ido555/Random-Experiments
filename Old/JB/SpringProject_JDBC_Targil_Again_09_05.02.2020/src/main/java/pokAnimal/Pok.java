package pokAnimal;

public class Pok {
	private int id, healthPoints, defense;
	private String name;
	private PokType type;

	public Pok(int id, int healthPoints, int defense, String name, PokType type) {
		this.id = id;
		this.healthPoints = healthPoints;
		this.defense = defense;
		this.name = name;
		this.type = type;
	}
	public Pok(int healthPoints, int defense, String name, PokType type) {
		this.healthPoints = healthPoints;
		this.defense = defense;
		this.name = name;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Pok [id=" + id + ", healthPoints=" + healthPoints + ", defense=" + defense + ", name=" + name
				+ ", type=" + type + "]";
	}
	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokType getType() {
		return type;
	}

	public void setType(PokType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

}
