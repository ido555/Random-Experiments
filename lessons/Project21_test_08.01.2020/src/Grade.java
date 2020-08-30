
public class Grade {
	private String profession;
	private int score;

	public Grade(String profession, int score) {
		this.profession = profession;
		this.score = score; // 
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Grade [profession=" + profession + ", score=" + score + "]";
	}

}
