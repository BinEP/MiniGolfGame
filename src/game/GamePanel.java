package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import templates.CShape;
import templates.Map;
import templates.Players;
import templates.Turn;

public class GamePanel extends JPanel implements ActionListener, KeyListener,
		MouseListener {

	public ArrayList<Map> maps = new ArrayList<Map>();
	public Map map;
	public Players players = new Players();
	public Turn pt = new Turn();

	public int holeNum = 1;

	public Point ball;
	public boolean ballMoving = false;
	public int ballSpeed = 0;

	public int deltaX = 0;
	public int deltaY = 0;

	public GamePanel() {
		// TODO Auto-generated constructor stub
		setBackground(Color.CYAN);
		setFocusable(true);
		addKeyListener(this);

		setup();

		Timer timer = new Timer((int) (1000 / 60), this);
		timer.start();

		map = maps.get(holeNum - 1);

	}

	public void setup() {
		// TODO Auto-generated method stub

		setupMaps();

	}

	public void setupMaps() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		moves();
	}

	@Override
	public void paintComponent(Graphics g2) {

		Graphics2D g = (Graphics2D) g2;
		drawMouse(g);
		drawMap(g);
		drawBall(g);
		drawStats(g);

	}

	public void drawMouse(Graphics2D g) {
		// TODO Auto-generated method stub
		Point mouseP = MouseInfo.getPointerInfo().getLocation();
		Point screenP = this.getLocationOnScreen();

		Point relativeP = new Point(mouseP.x - screenP.x, mouseP.y - screenP.y);

		g.setColor(Color.BLACK);
		g.drawLine(relativeP.x - 5, relativeP.y, relativeP.x + 5, relativeP.y);
		g.drawLine(relativeP.x, relativeP.y - 5, relativeP.x, relativeP.y + 5);
	}

	public void drawStats(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	public void drawBall(Graphics2D g) {
		// TODO Auto-generated method stub
		g.fillOval(ball.x, ball.y, 5, 5);
	}

	public void drawMap(Graphics2D g) {
		// TODO Auto-generated method stub

		Map m = maps.get(holeNum - 1);

		for (CShape s : m.getSurfaces()) {

			s.draw(g);

		}

	}

	public void moves() {
		// TODO Auto-generated method stub

		ball.x += deltaX;
		ball.y += deltaY;

		CShape s = map.getShape(ball);
		deltaX -= s.getTexture();
		deltaY -= s.getTexture();

		ballSpeed -= s.getTexture() * Math.sqrt(2);

	}

	public void checkBallFinished() {
		if (ballSpeed <= 0) {
			ballSpeed = 0;
			deltaX = 0;
			deltaY = 0;
			ballMoving = false;
			players.addStroke();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
