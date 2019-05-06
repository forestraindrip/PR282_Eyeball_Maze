package nz.ac.ara.marcusJ;

import java.util.Random;

public enum Direction {
	UP,
	RIGHT,
	DOWN,
	LEFT;
	
	static public Direction getRandomDirection() {
		Random random = new Random();
		Direction direction = values()[random.nextInt(values().length)];

		return direction;
	}
}
