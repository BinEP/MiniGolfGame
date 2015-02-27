package templates;

import java.awt.Point;
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

	public abstract ArrayList<Barrier> getBarriers();
	
	public abstract void setSurfaces();
	public abstract void setBarriers();
	
	public abstract CShape getShape(Point p);
	
	public abstract Point getStart();
	public abstract Point getHole();
	
	
	
}
