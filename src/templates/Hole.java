package templates;

import game.GamePanel;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Hole {

	public ArrayList<CShape> surfaces = new ArrayList<CShape>();
	public ArrayList<Polygon> barrier = new ArrayList<Polygon>();
	public CShape defaultShape = new CShape(0, 0, 500, 500, new Texture(
			Texture.MEDIUM));
	public GamePanel game;

	
	public Hole() {
		// TODO Auto-generated constructor stub
		setStuff();
	}
	
	
	public ArrayList<CShape> getSurfaces() {
		return surfaces;
	}
	
	private int getHeight() {
		// TODO Auto-generated method stub
		return 500;
	}

	private int getWidth() {
		// TODO Auto-generated method stub
		return 500;
	}

	public ArrayList<Polygon> getBarriers() {
		return barrier;
	}
	public Polygon getBarriers(double ballX, double ballY) {
		Polygon outerBarrier = barrier.get(0);
		Polygon p;
		if (!outerBarrier.contains(ballX, ballY))
			return outerBarrier;
		for (int i = 1; i < barrier.size(); i++) {
			p = barrier.get(i);
			if (p.contains(ballX, ballY))
				return p;
		}

		return barrier.get(0);
	}
	
	public void setSurfaces() {
		setStuff();
	}
	public void setBarriers() {
		
	}
	
	public void setStuff() {
		surfaces.add(defaultShape);
		barrier.add(defaultShape);
	}
	
	public void addBarrier(Polygon bar) {
		barrier.add(bar);
	}
	
	public void addBarrier(int[] x, int[] y) {
		barrier.add(new Polygon(x, y, x.length));
	}
	
	public void addSurface(CShape bar) {
		surfaces.add(bar);
	}
	
	public void addSurface(int[] x, int[] y) {
		surfaces.add(new CShape(x, y, x.length));
	}
	
	public CShape getShape(Point p) {
		for (CShape s : surfaces) {

			if (s.contains(p))
				return s;

		}

		return defaultShape;
	}
	
	public Point getStart() {
		return new Point(20, 20);
	}
	public Point getHole() {
		return new Point(400, 400);
	}
	
	public boolean checkCollision(double ballX, double ballY) {
		Polygon outerBarrier = barrier.get(0);
		Rectangle r = new Rectangle((int) ballX, (int) ballY, 10, 10);
		Polygon p;
		if (!outerBarrier.contains(r))
			return true;
		for (int i = 1; i < barrier.size(); i++) {
			p = barrier.get(i);
			if (p.contains(r))
				return true;
		}
		return false;
	}

	public double getLineSlope(double ballX, double ballY, double deltaX, double deltaY) {

		Line2D.Double lineSeg = getLineSeg(ballX, ballY, deltaX, deltaY);

		Point2D p1 = lineSeg.getP1();
		Point2D p2 = lineSeg.getP2();

		double slope = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
		return slope;

	}

	
	public double[] getLineSlopeArr(double ballX, double ballY, double deltaX, double deltaY) {

		Line2D.Double lineSeg = getLineSeg(ballX, ballY, deltaX, deltaY);

		Point2D p1 = lineSeg.getP1();
		Point2D p2 = lineSeg.getP2();

		double[] slope = { (p1.getX() - p2.getX()), (p1.getY() - p2.getY()) };
		return slope;

	}

	public Line2D.Double getLineSeg(double ballX, double ballY, double deltaX, double deltaY) {
		
//		System.out.println("Ball X: " + ballX);
//		System.out.println("Ball Y: " + ballY);
//		System.out.println();
		
		Polygon bar = getBarriers(ballX, ballY);

		int[] xpoints = bar.xpoints;
		int[] ypoints = bar.ypoints;
		int npoints = bar.npoints;

		Line2D.Double lineSeg = new Line2D.Double();
		Line2D.Double r = new Line2D.Double(ballX -  2 * deltaX, ballY - 2 * deltaY, ballX + 10 + 2 * deltaX, ballY + 5 + 2 * deltaY);
		
		for (int i = 0; i < npoints - 1; i++) {

			int x1 = xpoints[i];
			int x2 = xpoints[i + 1];

			int y1 = ypoints[i];
			int y2 = ypoints[i + 1];

			lineSeg.setLine(x1, y1, x2, y2);
			
//			Graphics2D g = (Graphics2D) game.getGraphics();
//			game.paintComponent(g);
//			g.setColor(Color.RED);
//			g.draw(lineSeg);
//			g.draw(r);
//			game.repaint();
			
//				System.out.println(lineSeg.ptLineDist(ballX, ballY));
				if (lineSeg.intersectsLine(r)) {
					return lineSeg;

				}
			

		}
		
		if (ballY < 10) {
			return new Line2D.Double(0, 0, 500, 0);
		} else if (ballY > 490) {
			return new Line2D.Double(0, 500, 500, 500);
		} else if (ballX < 10) {
			return new Line2D.Double(0, 0, 0, 500);
		} else {
			return new Line2D.Double(500, 0, 500, 500);
		}
	}

	public double[] getUnit(double slopeX, double slopeY) {

		double slopeScale = Math.sqrt(slopeX * slopeX + slopeY * slopeY);
		System.out.println("Slope Scale: " + slopeScale);
		
		slopeY /= slopeScale;
		slopeX /= slopeScale;
		
		System.out.println("Slope Y: " + slopeY);
		System.out.println("Slope X: " + slopeX);

		double[] slopes = { slopeY, slopeX };
		return slopes;
	}

	public void setGame(GamePanel game) {
		// TODO Auto-generated method stub
		this.game = game;
	}
	
	public void draw(Graphics2D g) {
		
		g.setStroke(new BasicStroke(4));

		for (Polygon s : barrier) {

			g.draw(s);

		}
//		g.draw(defaultShape);
		Point h = getHole();
		g.drawOval(h.x, h.y, 20, 20);
		
		
		
	}
}
