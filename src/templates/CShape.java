package templates;

import java.awt.Polygon;

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

}
