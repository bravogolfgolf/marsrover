package rover;

public class Rover {
	private Point position;
	private Direction direction;
	private Grid planet;

	public Rover(int x, int y, int z, String direction) {
		setPosition(x, y, z);
		setDirection(Direction.create(direction));
	}

	private void setPosition(int x, int y, int z) {
		setPosition(new Point(x , y, z));
	}

	private void setPosition(Point position) {
		this.position = position;
	}

	public Point getPosition() {
		return position;
	}

	private void setDirection(Direction direction){
		this.direction = direction;
	}

	private Direction getDirection() {
		return direction;
	}

	public String getHeading() {
		return getDirection().getCompassPoint();
	}

	public void landOnPlanet(Grid planet) {	
		this.planet = planet;
	}

	public Grid getPlanetGrid() {
		return planet;
	}

	public void move(String instruction) {
		if (instruction == "R") turnRight();
		if (instruction == "L") turnLeft();
		if (instruction == "F") goForward();
		if (instruction == "B") goBackward();
	}

	private void turnRight(){
		setDirection(getDirection().turnRight());
	}

	private void turnLeft() {
		setDirection(getDirection().turnLeft());
	}

	private void goForward() {
		setPosition(getDirection().goForward(getPosition(), getPlanetGrid()));
	}

	private void goBackward() {
		setPosition(getDirection().goBackward(getPosition(), getPlanetGrid()));
	}
}