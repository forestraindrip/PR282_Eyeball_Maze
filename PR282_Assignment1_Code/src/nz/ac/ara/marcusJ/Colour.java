package nz.ac.ara.marcusJ;

import java.util.Random;

public enum Colour {
	NONE, BLUE, YELLOW, GREEN, RED, PURPLE;

	static public Colour getRandomColour() {
		Colour colour;
		Random random = new Random();

		do {
			int indexRandom = random.nextInt(values().length);
			colour = values()[indexRandom];
		} while (colour == Colour.NONE);

		return colour;
	}
	public String toString() {
		return ordinal()+ "";
	}
}
