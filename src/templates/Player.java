package templates;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class Player {

	private int strokes;
	private int score;
	private String name;
	private Turn pt = new Turn();

	public Player() {
		// TODO Auto-generated constructor stub

	}

	public void drawStats(Graphics2D g) {

	}

	public int getStrokes() {
		return strokes;
	}

	public void setStrokes(int strokes) {
		this.strokes = strokes;
	}

	public void addStroke() {
		this.strokes++;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
