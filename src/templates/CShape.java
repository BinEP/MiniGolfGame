package templates;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class CShape extends Polygon {

	private double slope = 0;
	private double texture = Texture.MEDIUM;

	public CShape() {
		// TODO Auto-generated constructor stub
	}

	public CShape(int[] xpoints, int[] ypoints, int npoints) {
		super(xpoints, ypoints, npoints);
	}

	public CShape(int[] xpoints, int[] ypoints, int npoints, double slope) {
		super(xpoints, ypoints, npoints);
		this.slope = slope;

	}

	public CShape(int[] xpoints, int[] ypoints, int npoints, Texture t) {
		super(xpoints, ypoints, npoints);
		this.texture = t.getTexture();

	}

	public CShape(int[] xpoints, int[] ypoints, int npoints, double slope,
			Texture t) {
		super(xpoints, ypoints, npoints);
		this.slope = slope;
		this.texture = t.getTexture();

	}

	public CShape(Rectangle s) {

		xpoints = new int[4];
		ypoints = new int[4];

		xpoints[0] = s.x;
		ypoints[0] = s.y;

		xpoints[1] = s.x + s.width;
		ypoints[1] = s.y;

		xpoints[2] = s.x + s.width;
		ypoints[2] = s.y + s.height;

		xpoints[3] = s.x;
		ypoints[3] = s.y + s.height;
	}

	public CShape(int x, int y, int w, int h, Texture t) {

		xpoints = new int[4];
		ypoints = new int[4];

		xpoints[0] = x;
		ypoints[0] = y;

		xpoints[1] = x + w;
		ypoints[1] = y;

		xpoints[2] = x + w;
		ypoints[2] = y + h;

		xpoints[3] = x;
		ypoints[3] = y + h;
		
		texture = t.getTexture();

	}

	public CShape(Polygon s) {
		this.xpoints = s.xpoints;
		this.ypoints = s.ypoints;

	}

	public CShape(Line2D s) {

		xpoints = new int[2];
		ypoints = new int[2];

		xpoints[0] = (int) s.getX1();
		ypoints[0] = (int) s.getY1();

		xpoints[1] = (int) s.getX2();
		ypoints[1] = (int) s.getY2();

	}

	public CShape(int[] x, int[] y) {

		xpoints = x;
		ypoints = y;

	}

	public void setTexture(Texture t) {
		this.texture = t.getTexture();

	}

	public void setTexture(double t) {

		this.texture = t;

	}

	public double getTexture() {
		return texture;
	}

	public double getSlope() {
		return slope;
	}

	public void draw(Graphics2D g) {

		g.fill(this);
	}

}
