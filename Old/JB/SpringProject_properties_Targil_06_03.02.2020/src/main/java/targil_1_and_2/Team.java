package targil_1_and_2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Team {
	private String name;
	private int lives;
	public Team(String name, int lives) {
		this.name = name;
		this.lives = lives;
	}
	
	@Override
	public String toString() {
		return "Team [name=" + name + ", lives=" + lives + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int lives) {
		this.lives = lives;
	}
	

}
