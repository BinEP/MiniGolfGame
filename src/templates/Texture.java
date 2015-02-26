package templates;

public class Texture {

	public double t = MEDIUM;
	
	public Texture(double t) {
		// TODO Auto-generated constructor stub
		this.t = t;
	}
	
	public static final double HARD = .2;
	public static final double CLIPPED = .6;
	public static final double MEDIUM = .9;
	public static final double GROWN = 2;
	public static final double SAND = 3;
	public static final double WATER = 10;

	public double getTexture() {
		return t;
	}
}
