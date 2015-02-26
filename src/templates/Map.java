package templates;

import java.awt.Point;
import java.util.ArrayList;

public abstract class Map {

	public Map() {
		// TODO Auto-generated constructor stub
	}
	
	private ArrayList<CShape> surfaces = new ArrayList<CShape>();
	private ArrayList<Barrier> barrier = new ArrayList<Barrier>();
	private CShape defaultShape = new CShape(0, 0, getWidth(), getHeight(), new Texture(Texture.MEDIUM));
	public ArrayList<CShape> getSurfaces() {
		
		return surfaces;
	}
	
	private int getHeight() {
		// TODO Auto-generated method stub
		return 500;
	}

	private int getWidth() {
		// TODO Auto-generated method stub
		return 500;
	}

	public ArrayList<Barrier> getBarriers() {
		
		return barrier;
	}
	
	public abstract void setSurfaces();
	public abstract void setBarriers();
	
	public CShape getShape(Point p) {
		
		for (CShape s : surfaces) {
			
			if (s.contains(p)) return s;
			
		}
		
		return defaultShape;
	}
	
	public abstract Point getStart();
	public abstract Point getHole();
	
	
	
}
