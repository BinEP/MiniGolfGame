package holes;

import java.awt.Point;

import templates.HoleMethods;

public class Hole3 extends HoleMethods {

	public Hole3() {
		// TODO Auto-generated constructor stub
	super();
	}

	@Override
	public void setSurfaces() {
		// TODO Auto-generated method stub
setStuff();
	}

	@Override
	public void setBarriers() {
		// TODO Auto-generated method stub
setStuff();
	}

	public void setStuff() {
		// TODO Auto-generated method stub
		int[] x1 = {187, 314, 399, 441, 441, 443, 417, 365, 210, 128, 69, 50, 47, 75, 0, 0, };
		int[] y1 = {30, 30, 72, 121, 203, 293, 373, 412, 433, 432, 350, 262, 141, 62, 0, 0, };
		addSurface(x1, y1);
		addBarrier(x1, y1);

		int[] x2 = {265, 295, 215, 131, 127, 0, 0, 0, };
		int[] y2 = {108, 309, 309, 237, 135, 0, 0, 0, };
		addSurface(x2, y2);
		addBarrier(x2, y2);

		int[] x3 = {379, 386, 0, 0, };
		int[] y3 = {122, 332, 0, 0, };
		addSurface(x3, y3);
		addBarrier(x3, y3);
	}

	@Override
	public Point getStart() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Point getHole() {
		// TODO Auto-generated method stub
		return null;
	}

}
