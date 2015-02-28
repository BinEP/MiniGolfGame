package templates;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

public abstract class Map {

	public Map() {
		// TODO Auto-generated constructor stub
	}
	
	
	public abstract ArrayList<CShape> getSurfaces();
	
	private int getHeight() {
		// TODO Auto-generated method stub
		return 500;
	}

	private int getWidth() {
		// TODO Auto-generated method stub
		return 500;
	}

	public abstract ArrayList<Polygon> getBarriers();
	public abstract Polygon getBarriers(double ballX, double ballY);
	
	public abstract void setSurfaces();
	public abstract void setBarriers();
	
	public abstract CShape getShape(Point p);
	
	public abstract Point getStart();
	public abstract Point getHole();
	
	public abstract boolean checkCollision(double ballX, double ballY);


	public abstract double[] getLineSlopeArr(double ballX, double ballY);


	public abstract double[] getUnit(double d, double e);
	
	
}
