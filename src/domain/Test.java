package domain;

import java.util.Set;

public class Test {
	private Set<Question> vraag;
	private int score;

	public Test(Set<Question> vraag, int score) {
		setVraag(vraag);
		setScore(score);
	}

	public Set<Question> getVraag() {
		return vraag;
	}

	public void setVraag(Set<Question> vraag) {
		this.vraag = vraag;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	
	
	

}
