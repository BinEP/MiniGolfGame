package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import templates.Map;
import templates.Players;
import templates.Turn;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	
	public ArrayList<Map> maps = new ArrayList<Map>();
	public ArrayList<Players> object = new ArrayList<Players>();
	public Turn pt = new Turn();
	
	public GamePanel() {
		// TODO Auto-generated constructor stub
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		
		setup();

		Timer timer = new Timer((int) (1000 / 60), this);
		timer.start();
	
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
		drawMap(g);
		drawBall(g);
		drawStats(g);
		
	}
	
	public void drawStats(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	public void drawBall(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	public void drawMap(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}

	public void moves() {
		// TODO Auto-generated method stub
		
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

	
	

}
