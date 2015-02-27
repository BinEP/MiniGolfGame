package templates;

public class Texture {

	public double t = MEDIUM;
	
	public Texture(double t) {
		// TODO Auto-generated constructor stub
		this.t = t;
	}
	
	public static final double HARD = .95;
	public static final double CLIPPED = .8;
	public static final double MEDIUM = .7;
	public static final double GROWN = .55;
	public static final double SAND = .45;
	public static final double WATER = 0;

	public double getTexture() {
		return t;
	}
}
