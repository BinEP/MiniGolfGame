package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.BasicStroke;

import templates.CShape;
import templates.Map;
import templates.Players;
import templates.Turn;
import maps.*;

public class GamePanel extends JPanel implements ActionListener, KeyListener,
		MouseListener {

	public ArrayList<Map> holes = new ArrayList<Map>();
	public Map hole;
	public Players players = new Players();
	public Turn pt = new Turn();

	public int holeNum = 1;

	public double ballX;
	public double ballY;
	public boolean ballMoving = false;
	public double ballSpeed = 0;

	public double deltaX = 0;
	public double deltaY = 0;

	public GamePanel(int pNum) {
		// TODO Auto-generated constructor stub
		setBackground(Color.CYAN);
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);

		setup(pNum);

		Timer timer = new Timer((int) (1000 / 60), this);
		timer.start();

		hole = holes.get(holeNum - 1);

	}

	public void setup(int pNum) {
		// TODO Auto-generated method stub

		setupMaps();
		players.setUpPlayers(pNum);
		setBall();

	}

	public void setupMaps() {
		// TODO Auto-generated method stub
		holes.add(new Hole1());
		holes.add(new Hole2());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		moves();
	}

	@Override
	public void paintComponent(Graphics g2) {

		super.paintComponent(g2);
		Graphics2D g = (Graphics2D) g2;
		hole.setGame(this);
		drawMouse(g);
		drawHole(g);
		drawBall(g);
		drawStats(g);

	}

	public void drawMouse(Graphics2D g) {
		// TODO Auto-generated method stub
		Point mouseP = MouseInfo.getPointerInfo().getLocation();
		Point screenP = this.getLocationOnScreen();

		Point relativeP = new Point(mouseP.x - screenP.x, mouseP.y - screenP.y);

		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(2));
		g.drawLine(relativeP.x - 5, relativeP.y, relativeP.x + 5, relativeP.y);
		g.drawLine(relativeP.x, relativeP.y - 5, relativeP.x, relativeP.y + 5);
	}

	public void drawStats(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	public void setBall() {

		ballX = holes.get(holeNum - 1).getStart().getX();
		ballY = holes.get(holeNum - 1).getStart().getY();

	}

	public void drawBall(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillOval((int) ballX, (int) ballY, 10, 10);
	}

	public void drawHole(Graphics2D g) {
		// TODO Auto-generated method stub

		Map m = holes.get(holeNum - 1);

		m.draw(g);

	}

	public void moves() {
		// TODO Auto-generated method stub

		ballX += deltaX;
		ballY += deltaY;
		
		calculateBarriers();
		
//		calculateBarriers();
		// CShape s = hole.getShape(ball);
		// System.out.println("Texture: " + s.getTexture());

		if (ballMoving) {
			double angle = Math.atan(deltaY / deltaX);
			ballSpeed *= 0.9;
			deltaX = ballSpeed * Math.cos(angle) * (deltaX < 0 ? -1 : 1);
			deltaY = ballSpeed * Math.sin(angle) * (deltaX < 0 ? -1 : 1);
		}
//		System.out.println("Deltas");
//		System.out.println("dx:\t" + deltaX);
//		System.out.println("dy:\t" + deltaY);
//
//		System.out.println("Ball Speed: " + ballSpeed);
		checkBallFinished();
		checkInHole();
		repaint();

	}

	public void calculateBarriers() {
		// TODO Auto-generated method stub

		if (hole.checkCollision(ballX, ballY)) {
			rotateBallDirection();
		}

		Graphics2D g = (Graphics2D) this.getGraphics();
		if (g != null) {
			g.setStroke(new BasicStroke(4));
			g.drawLine(50, 50, (int) (50 + ballX), (int) (50 + ballY));
		}
	}

	public void rotateBallDirection() {

		// Polygon b = hole.getBarriers(ballX, ballY);

		double angle = getAngle();
		// Line2D.Double line = b.getLineSeg(ballX, ballY);

		rotate(angle, deltaX, deltaY);

	}

	public void rotate(double angle, double endX, double endY) {

		angle = Math.toRadians(angle);
		double theCos = Math.cos(angle);
		double theSin = Math.sin(angle);

		double[][] rotationMatrix = { { theCos, -theSin }, { theSin, theCos } };

		// double startXVal = rotationMatrix[0][0] * startX +
		// rotationMatrix[0][1] * startY;
		// double startYVal = rotationMatrix[1][0] * startX +
		// rotationMatrix[1][1] * startY;

		double endXVal = rotationMatrix[0][0] * endX + rotationMatrix[0][1]
				* endY;
		double endYVal = rotationMatrix[1][0] * endX + rotationMatrix[1][1]
				* endY;

		deltaX = endXVal;
		deltaY = endYVal;

	}

	public double getAngle() {

		double[] ballSlope = hole.getLineSlopeArr(ballX, ballY, deltaX, deltaY);
		double[] lineSlope = hole.getLineSlopeArr(ballX, ballY, deltaX, deltaY);

		ballSlope = hole.getUnit(ballSlope[0], ballSlope[1]);
		lineSlope = hole.getUnit(lineSlope[0], lineSlope[1]);

		double lSlope = ballSlope[1] / ballSlope[0];
		double bSlope = lineSlope[1] / lineSlope[0];

		double angle = 180 - 2 * Math.acos(bSlope / lSlope);
		return angle;
	}

	public void checkInHole() {
		// TODO Auto-generated method stub

		Point h = holes.get(holeNum - 1).getHole();
		Ellipse2D.Double eh = new Ellipse2D.Double(h.x + 5, h.y + 5, 10, 10);
		Rectangle ba = new Rectangle((int) ballX + 2, (int) ballY + 2, 6, 6);

		if (eh.intersects(ba)) {
			nextHole();

		}

	}

	public void nextHole() {
		// TODO Auto-generated method stub

		if (!(holeNum + 1 > holes.size())) {
			holeNum++;
			System.out.println("Next hole");
			hole = holes.get(holeNum - 1);
			setBall();

		}

	}

	public void checkBallFinished() {
		if (ballSpeed < 1) {
			resetMovement();
			players.addStroke();
		}
	}

	public void resetMovement() {
		ballSpeed = 0;
		deltaX = 0;
		deltaY = 0;
		ballMoving = false;
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

		if (!ballMoving) {

			// Point mouseP = MouseInfo.getPointerInfo().getLocation();
			Point mouseP = e.getPoint();
			mouseP.x -= 5;
			mouseP.y -= 5;
			// Point screenP = this.getLocationOnScreen();
			//
			// Point relativeP = new Point(mouseP.x - screenP.x, mouseP.y -
			// screenP.y);
			Point relativeP = new Point(mouseP.x - (int) ballX, mouseP.y
					- (int) ballY);

			// relativeP.x *= 3;
			// relativeP.y *= 3;

			// double d = relativeP.distance(ball);
			// double d = mouseP.distance(ball);
			// System.out.println("Distance: " + d);
			// ballSpeed = d;

			// int numerator = relativeP.y;
			// numerator -= numerator % 5;

			// int denominator = relativeP.x;
			// denominator -= denominator % 5;

			// System.out.println("Rounded to 5");
			// System.out.println(numerator);
			// System.out.println(denominator);

			// int div = Math.abs(gcm(numerator, denominator));
			// numerator /= div;
			// denominator /= div;

			// deltaY = (int) Math.ceil((double) numerator / 10);
			// deltaX = (int) Math.ceil((double) denominator / 10);

			// System.out.println("Lowest common denom");
			// System.out.println(numerator);
			// System.out.println(denominator);

			// deltaY = (int) (numerator * 1.7);
			// deltaX = (int) (denominator * 1.7);
			deltaY = relativeP.y / 9d;
			deltaX = relativeP.x / 9d;
			ballMoving = true;
			ballSpeed = Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));

		}

	}

	public int gcm(int a, int b) {
		return b == 0 ? a : gcm(b, a % b); // Not bad for one line of code :)
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
