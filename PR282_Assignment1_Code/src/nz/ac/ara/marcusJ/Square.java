package nz.ac.ara.marcusJ;

import com.google.gson.Gson;

public class Square extends Element {
	protected boolean isStart;
	protected boolean isGoal;
	protected Colour myColour;
	protected Symbol mySymbol;

	public Square(Position position, boolean isGoal, Colour colour, Symbol symbol) {
		super(position);
		this.isStart = false;
		this.isGoal = isGoal;
		this.myColour = colour;
		this.mySymbol = symbol;
	}

	// Methods
	static public Square createPassableSquare(Position position) {
		Colour colour = Colour.getRandomColour();
		Symbol symbol = Symbol.getRandomSymbol();
		return new Square(position, false, colour, symbol);
	}

	static public Square createImpassableSquare(Position position) {
		return new Square(position, false, Colour.NONE, Symbol.NONE);
	}

	public void changeToBlankSquare() {
		this.myColour = Colour.NONE;
		this.mySymbol = Symbol.NONE;
	}

	public boolean isSameSymbol(Square square) {
		boolean result = false;
		if (this.mySymbol.equals(square.mySymbol)) {
			result = true;
		}
		return result;
	}

	public boolean isSameColour(Square square) {
		boolean result = false;
		if (this.myColour.equals(square.myColour)) {
			result = true;
		}
		return result;
	}

	public boolean isSamePosition(Position position) {
		int myX = this.myPosition.X;
		int myY = this.myPosition.Y;
		int anotherX = position.X;
		int anotherY = position.Y;

		boolean result = false;
		if (myX == anotherX && myY == anotherY) {
			result = true;
		}
		return result;
	}

	@Override
	public String toString() {
		String output = "[";
		output += this.myColour + "";
		output += this.mySymbol + "";
//		output += this.isStart ? "T" : "F" + "";
//		output += this.isGoal? "T" : "F"  + "";
//		output += this.myPosition.X + " ";
//		output += this.myPosition.Y + " ";
		output += "]";
		return output;
	}

	static public Square load(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Square.class);
	}
}
