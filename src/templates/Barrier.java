package templates;

import java.awt.Dimension;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class Barrier extends Polygon {

	private int[] xpoints;
	private int[] ypoints;

	public Barrier() {
		// TODO Auto-generated constructor stub
	}

	public Barrier(int[] xpoints, int[] ypoints, int npoints) {
		super(xpoints, ypoints, npoints);
		// TODO Auto-generated constructor stub
		this.xpoints = xpoints;
		this.ypoints = ypoints;
	}

	public Barrier(Rectangle s) {

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

	public Barrier(int x, int y, int w, int h) {

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

	}

	public Barrier(Polygon s) {
		this.xpoints = s.xpoints;
		this.ypoints = s.ypoints;

	}

	public Barrier(Line2D s) {

		xpoints = new int[2];
		ypoints = new int[2];

		xpoints[0] = (int) s.getX1();
		ypoints[0] = (int) s.getY1();

		xpoints[1] = (int) s.getX2();
		ypoints[1] = (int) s.getY2();

	}

	public Barrier(int[] x, int[] y) {

		xpoints = x;
		ypoints = y;

	}

}