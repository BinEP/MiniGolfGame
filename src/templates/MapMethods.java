package templates;

import java.awt.Point;

public abstract class MapMethods extends Map {

	public MapMethods() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void setSurfaces();
	public abstract void setBarriers();
	public abstract void setBarriers(int[] x, int[] y);
	public abstract Point getStart();
	public abstract Point getHole();

}
