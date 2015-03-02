package holes;

import java.awt.Point;

import templates.HoleMethods;

public class Hole4 extends HoleMethods {

	public Hole4() {
		// TODO Auto-generated constructor stub
	super();
	}

	@Override
	public Point getStart() {
		// TODO Auto-generated method stub
		return new Point(52, 427);
	}

	@Override
	public Point getHole() {
		// TODO Auto-generated method stub
		return new Point(312, 327);
	}

	@Override
	public void setStuff() {
		// TODO Auto-generated method stub
		int[] x1 = {14, 11, 488, 482, 139, 126, 374, 358, 270, 275, 200, 206, 418, 417, 94, 96, };
		int[] y1 = {463, 11, 14, 476, 469, 105, 115, 362, 356, 194, 197, 407, 422, 71, 71, 463, };
		addSurface(x1, y1);
		addBarrier(x1, y1);

	}

}
