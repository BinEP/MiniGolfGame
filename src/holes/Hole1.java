package holes;

import game.GamePanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import templates.CShape;
import templates.HoleMethods;
import templates.Texture;

public class Hole1 extends HoleMethods {

	private ArrayList<CShape> surfaces = new ArrayList<CShape>();
	private ArrayList<Polygon> barrier = new ArrayList<Polygon>();
	private CShape defaultShape = new CShape(0, 0, 500, 500, new Texture(
			Texture.MEDIUM));
	
	public GamePanel game;

	public Hole1() {
		// TODO Auto-generated constructor stub
		super();
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

	@Override
	public Point getHole() {
		// TODO Auto-generated method stub
		return new Point(400, 450);
	}

	@Override
	public void setStuff() {
		// TODO Auto-generated method stub
		int[] x = { 17, 20, 37, 52, 72, 94, 114, 143, 165, 187, 209, 238, 266,
				294, 325, 348, 374, 417, 454, 472, 468, 296, 288, 284, 273,
				266, 253, 240, 226, 221, 209, 198, 192 };
		int[] y = { 472, 81, 74, 66, 59, 49, 48, 41, 40, 36, 36, 36, 37, 42,
				46, 52, 56, 62, 63, 68, 479, 477, 297, 288, 286, 282, 284, 285,
				287, 294, 292, 465, 472 };

		// setBarriers(x, y);
		addSurface(x, y);
		addBarrier(x, y);
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

//	@Override
//	public Polygon getBarriers(double ballX, double ballY) {
//		// TODO Auto-generated method stub
//
//		Polygon outerBarrier = barrier.get(0);
//		Polygon p;
//		if (!outerBarrier.contains(ballX, ballY))
//			return outerBarrier;
//		for (int i = 1; i < barrier.size(); i++) {
//			p = barrier.get(i);
//			if (p.contains(ballX, ballY))
//				return p;
//		}
//
//		return barrier.get(0);
//	}

	
}
