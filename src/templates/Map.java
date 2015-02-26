package templates;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Map {

	public Map() {
		// TODO Auto-generated constructor stub
	}
	
	private ArrayList<CShape> surfaces = new ArrayList<CShape>();
	private ArrayList<Barrier> barrier = new ArrayList<Barrier>();
	
	public ArrayList<CShape> getSurfaces() {
		
		return surfaces;
	}
	
	public abstract void setSurfaces();
	public abstract void setBarriers();
	
	public abstract Point getStart();
	public abstract Point getHole();
	
	
	
}
