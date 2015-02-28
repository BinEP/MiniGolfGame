package maps;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import templates.CShape;
import templates.Map;
import templates.Texture;

public class Hole1 extends Map {

	private ArrayList<CShape> surfaces = new ArrayList<CShape>();
	private ArrayList<Polygon> barrier = new ArrayList<Polygon>();
	private CShape defaultShape = new CShape(0, 0, 500, 500, new Texture(
			Texture.MEDIUM));

	public Hole1() {
		// TODO Auto-generated constructor stub
		setSurfaces();
		setBarriers();
	}

	@Override
	public void setSurfaces() {
		// TODO Auto-generated method stub
		int[] x = { 17, 20, 37, 52, 72, 94, 114, 143, 165, 187, 209, 238, 266,
				294, 325, 348, 374, 417, 454, 472, 468, 296, 288, 284, 273,
				266, 253, 240, 226, 221, 209, 198, 192 };
		int[] y = { 472, 81, 74, 66, 59, 49, 48, 41, 40, 36, 36, 36, 37, 42,
				46, 52, 56, 62, 63, 68, 479, 477, 297, 288, 286, 282, 284, 285,
				287, 294, 292, 465, 472 };

		// setBarriers(x, y);
		surfaces.add(new CShape(x, y, x.length));
	}

	@Override
	public void setBarriers() {
		// TODO Auto-generated method stub
		int[] x = { 17, 20, 37, 52, 72, 94, 114, 143, 165, 187, 209, 238, 266,
				294, 325, 348, 374, 417, 454, 472, 468, 296, 288, 284, 273,
				266, 253, 240, 226, 221, 209, 198, 192 };
		int[] y = { 472, 81, 74, 66, 59, 49, 48, 41, 40, 36, 36, 36, 37, 42,
				46, 52, 56, 62, 63, 68, 479, 477, 297, 288, 286, 282, 284, 285,
				287, 294, 292, 465, 472 };

		barrier.add(new Polygon(x, y, x.length));
	}

	public void setBarriers(int[] x, int[] y) {
		// TODO Auto-generated method stub
		barrier.add(new Polygon(x, y, x.length));
	}

	@Override
	public Point getStart() {
		// TODO Auto-generated method stub
		return new Point(30, 450);
	}

	public CShape getShape(Point p) {

		for (CShape s : surfaces) {

			if (s.contains(p))
				return s;

		}

		return defaultShape;
	}

	@Override
	public Point getHole() {
		// TODO Auto-generated method stub
		return new Point(400, 450);
	}

	/*
	 * Shape 1 Points [18, 473] [152, 471] [156, 283] [177, 268] [204, 260]
	 * [219, 260] [236, 264] [250, 271] [261, 279] [262, 350] [283, 367] [305,
	 * 373] [325, 375] [344, 375] [358, 375] [368, 372] [378, 368] [388, 362]
	 * [398, 356] [401, 347] [403, 310] [403, 251] [403, 216] [403, 188] [401,
	 * 112] [401, 73] [391, 58] [373, 45] [352, 36] [327, 30] [308, 26] [282,
	 * 23] [261, 21] [235, 21] [207, 23] [172, 26] [145, 28] [130, 28] [112, 33]
	 * [92, 34] [71, 34] [58, 34] [45, 34] [29, 34] [21, 34] Shape 2 Points
	 * [158, 78] [220, 82] [235, 88] [238, 98] [239, 113] [239, 126] [235, 143]
	 * [225, 152] [216, 155] [200, 158] [188, 159] [177, 159] [165, 159] [157,
	 * 159] [158, 135] [179, 137] [196, 135] [209, 131] [213, 126] [215, 119]
	 * [215, 115] [214, 108] [201, 105] [193, 103] [176, 101] [169, 100] [162,
	 * 99] [159, 99] Shape 3 Points [184, 195] [218, 195] [218, 224] [188, 223]
	 * [184, 224] Shape 4 Points [283, 151] [348, 156] [346, 173] [285, 172]
	 * [280, 172] [280, 152] [347, 151] [349, 171] [347, 175] [282, 173]
	 */
	@Override
	public ArrayList<CShape> getSurfaces() {
		// TODO Auto-generated method stub

		return surfaces;
	}

	@Override
	public ArrayList<Polygon> getBarriers() {
		// TODO Auto-generated method stub
		return barrier;
	}

	@Override
	public Polygon getBarriers(double ballX, double ballY) {
		// TODO Auto-generated method stub

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

	public double getLineSlope(double ballX, double ballY) {

		Line2D.Double lineSeg = getLineSeg(ballX, ballY);

		Point2D p1 = lineSeg.getP1();
		Point2D p2 = lineSeg.getP2();

		double slope = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
		return slope;

	}

	public double[] getLineSlopeArr(double ballX, double ballY) {

		Line2D.Double lineSeg = getLineSeg(ballX, ballY);

		Point2D p1 = lineSeg.getP1();
		Point2D p2 = lineSeg.getP2();

		double[] slope = { (p1.getX() - p2.getX()), (p1.getY() - p2.getY()) };
		return slope;

	}

	public Line2D.Double getLineSeg(double ballX, double ballY) {

		Polygon bar = getBarriers(ballX, ballY);

		int[] xpoints = bar.xpoints;
		int[] ypoints = bar.ypoints;
		int npoints = bar.npoints;

		Line2D.Double lineSeg = new Line2D.Double();
		Rectangle r = new Rectangle();

		for (int i = 0; i < npoints - 1; i++) {

			int x1 = xpoints[i];
			int x2 = xpoints[i + 1];

			int y1 = ypoints[i];
			int y2 = ypoints[i + 1];

			lineSeg.setLine(x1, y1, x2, y2);
			r.setBounds((int) ballX, (int) ballY, 10, 10);

			if (i > 30) {
				System.out.println(lineSeg.ptLineDist(ballX, ballY));
				if (lineSeg.intersects(r)) {
					return lineSeg;

				}
			}

		}
		return null;
	}

	public double[] getUnit(double slopeX, double slopeY) {

		double slopeScale = Math.sqrt(slopeX * slopeX + slopeY * slopeY);

		slopeY /= slopeScale;
		slopeX /= slopeScale;

		double[] slopes = { slopeY, slopeX };
		return slopes;
	}

}
