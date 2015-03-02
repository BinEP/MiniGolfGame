package templates;

import java.awt.Point;

public abstract class HoleMethods extends Hole {

	public HoleMethods() {
		// TODO Auto-generated constructor stub
	}
	
//	public abstract void setSurfaces();
//	public abstract void setBarriers();
//	public abstract void setBarriers(int[] x, int[] y);
	public abstract Point getStart();
	public abstract Point getHole();
	public abstract void setStuff();
}
