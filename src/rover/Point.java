package rover;

public class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.setX(x);
		this.setY(y);

	}

	public void setY(int y) {
		this.y =  y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;	
	}

}