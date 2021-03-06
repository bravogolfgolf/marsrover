package rover;

public class East extends Direction {

	@Override
	String getCompassPoint(){
		return "E";
	}

	@Override
	Direction turnRight() {
		return new South();
	}

	@Override
	Direction turnLeft() {
		return new North();
	}

	@Override
	Point goForward(Point position, Grid planet) {
		x = position.x;
		y = position.y;
		z = position.z;

		if (onRightEdgeOfGrid(x, planet)) x = wrapToLeftEdgeOfGrid(x);
		else x = moveRightOnGrid(x);

		planet.checkForObstacle(new Point(x,y,z));
		
		return new Point(x,y,z);
	}

	@Override
	Point goBackward(Point position, Grid planet) {
		x = position.x;
		y = position.y;
		z = position.z;

		if(onLeftEdgeOfGrid(x)) x = wrapToRightEdgeOfGrid(x,planet);
		else x = moveLeftOnGrid(x);

		planet.checkForObstacle(new Point(x,y,z));
		
		return new Point(x,y,z);
	}
}