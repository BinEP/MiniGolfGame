package templates;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Players extends JPanel {

	private ArrayList<Player> players = new ArrayList<Player>();
	private Turn pt = new Turn();

	public Players() {
		// TODO Auto-generated constructor stub

	}

	public void setUpPlayers(int pNum) {

		for (int i = 0; i < pNum; i++) {
			players.add(new Player());
		}

	}

	public void drawGrid(Graphics2D g) {

	}

	public void paintComponent(Graphics g2) {

		Graphics2D g = (Graphics2D) g2;

		drawGrid(g);
		drawStats(g);

	}

	public void drawStats(Graphics2D g) {
		// TODO Auto-generated method stub
		players.get(pt.turn - 1).drawStats(g);
	}

	public void addStroke() {
		players.get(pt.turn - 1).addStroke();
	}

}
