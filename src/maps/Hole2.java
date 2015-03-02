package maps;

import java.awt.Point;

import templates.Map;
import templates.MapMethods;

public class Hole2 extends MapMethods {

	public Hole2() {
		// TODO Auto-generated constructor stub
	super();
	}

	@Override
	public void setSurfaces() {
		// TODO Auto-generated method stub
		
		int[] x1 = {28, 22, 487, 477, 29}; 
		int[] y1 = {464, 23, 23, 482, 479};
		
		int[] x2 = {148, 167, 331, 414, 438, 411, 384, 320};
		int[] y2 = {416, 433, 404, 343, 227, 227, 331, 379};
		
		int[] x3 = {261, 132, 173, 277};
		int[] y3 = {390, 149, 140, 377};
		
		int[] x4 = {237, 344, 357, 252};
		int[] y4 = {156, 103, 121, 174};

		addSurface(x1, y1);
		addSurface(x2, y2);
		addSurface(x3, y3);
		addSurface(x4, y4);
	}

	@Override
	public void setBarriers() {
		// TODO Auto-generated method stub
		
		int[] x1 = {28, 22, 487, 477, 29}; 
		int[] y1 = {464, 23, 23, 482, 479};
		
		int[] x2 = {148, 167, 331, 414, 438, 411, 384, 320};
		int[] y2 = {416, 433, 404, 343, 227, 227, 331, 379};
		
		int[] x3 = {261, 132, 173, 277};
		int[] y3 = {390, 149, 140, 377};
		
		int[] x4 = {237, 344, 357, 252};
		int[] y4 = {156, 103, 121, 174};
		
		addBarrier(x1, y1);
		addBarrier(x2, y2);
		addBarrier(x3, y3);
		addBarrier(x4, y4);
	}

	@Override
	public void setBarriers(int[] x, int[] y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Point getStart() {
		// TODO Auto-generated method stub
		return new Point(50, 400);
	}

	@Override
	public Point getHole() {
		// TODO Auto-generated method stub
		return new Point(420, 50);
	}
	
	

}
