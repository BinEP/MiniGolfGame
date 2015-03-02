package maps;

import java.awt.Point;

import templates.Map;
import templates.MapMethods;

public class Hole2 extends MapMethods {

	public Hole2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setSurfaces() {
		// TODO Auto-generated method stub
		
		int[] x1 = {28, 22, 487, 477, 29, 0, 0, 0}; 
		int[] y1 = {434, -7, -7, 452, 449, -30, -30, -30};
		
		int[] x2 = {148, 167, 331, 414, 438, 411, 384, 320};
		int[] y2 = {386, 403, 374, 313, 197, 197, 301, 349};
		
		int[] x3 = {261, 132, 173, 277};
		int[] y3 = {360, 119, 110, 347};
		
		int[] x4 = {237, 344, 357, 252};
		int[] y4 = {126, 73, 91, 144};

		addSurface(x1, y1);
		addSurface(x2, y2);
		addSurface(x3, y3);
		addSurface(x4, y4);
	}

	@Override
	public void setBarriers() {
		// TODO Auto-generated method stub
		
		int[] x1 = {28, 22, 487, 477, 29, 0, 0, 0}; 
		int[] y1 = {434, -7, -7, 452, 449, -30, -30, -30};
		
		int[] x2 = {148, 167, 331, 414, 438, 411, 384, 320};
		int[] y2 = {386, 403, 374, 313, 197, 197, 301, 349};
		
		int[] x3 = {261, 132, 173, 277};
		int[] y3 = {360, 119, 110, 347};
		
		int[] x4 = {237, 344, 357, 252};
		int[] y4 = {126, 73, 91, 144};
		
		addBarrier(x1, y1);
		addBarrier(x2, y2);
		addSurface(x3, y3);
		addSurface(x4, y4);
	}

	@Override
	public void setBarriers(int[] x, int[] y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getStart() {
		// TODO Auto-generated method stub
		return new Point(20, 450);
	}

	@Override
	public Point getHole() {
		// TODO Auto-generated method stub
		return new Point(480, 20);
	}
	
	

}
