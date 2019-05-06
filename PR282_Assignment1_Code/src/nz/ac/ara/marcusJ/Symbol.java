package nz.ac.ara.marcusJ;

import java.util.Random;

public enum Symbol {

	NONE, CROSS, STAR, DIAMOND, FLOWER, THUNDERBOLT;

	static public Symbol getRandomSymbol() {
		Symbol symbol;
		Random random = new Random();
		do {
			int indexRandom = random.nextInt(values().length);
			symbol = values()[indexRandom];
		} while (symbol == Symbol.NONE);

		return symbol;
	}
	public String toString() {
		return ordinal()+ "";
	}
}
