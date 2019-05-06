package nz.ac.ara.marcusJ;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SquareTest {

	@Nested
	class testSquare {
		Square aSquare;

		@BeforeEach
		void beforeEach() {
			Position position = new Position(2, 2);
			aSquare = new Square(position, false, Colour.getRandomColour(), Symbol.getRandomSymbol());
		}

		@Test
		void testSquareType() {
			final String errMsg = "Should return a Square instance";
			final Class<Square> expected = Square.class;

			final Class<?> actual = aSquare.getClass();

			assertEquals(expected, actual, errMsg);
		}

		@Test
		void testSquareHasIsStart() {
			final String errMsg = "Should have isStart with value FALSE";
			final boolean expected = false;

			final boolean actual = aSquare.isStart;

			assertEquals(expected, actual, errMsg);
		}

		@Test
		void testSquareHasIsGoal() {
			final String errMsg = "Should have isGoal with value FALSE";
			final boolean expected = false;

			final boolean actual = aSquare.isGoal;

			assertEquals(expected, actual, errMsg);
		}
	}

	// 1. Automatically create passable square with colour and symbol
	@Nested
	class testCreatePassableSquare {
		@Test
		void testCreatePassableSquareType() {
			final Position position = new Position(2, 2);
			final Square square = Square.createPassableSquare(position);
			final Class<Square> expected = Square.class;
			final String errMsg = "Should return a Square instance";

			final Class<?> actual = square.getClass();

			assertEquals(expected, actual, errMsg);
		}

		// 1.a Test colour
		@Test
		void testCreatePassableSquareColour() {
			for (int i = 0; i < 100; ++i) {
				final String errMsg = "Colour should not be Colour.NONE";

				final Colour none = Colour.NONE;

				final Position position = new Position(i, i);
				final Square square = Square.createPassableSquare(position);
				final Colour colour = square.myColour;

				assertTrue(colour != none, errMsg);
			}
		}

		// 1.b Test symbol
		@Test
		void testCreatePassableSquareSymbol() {
			for (int i = 0; i < 100; ++i) {
				final String errMsg = "Symbol should not be Symbol.NONE";
				final Symbol none = Symbol.NONE;

				final Position position = new Position(i, i);
				final Square square = Square.createPassableSquare(position);
				final Symbol symbol = square.mySymbol;

				assertTrue(symbol != none, errMsg);
			}
		}
	}

	// 2. Automatically create impassable square with
	@Nested
	class testCreateImpassableSquare {
		@Test
		void testCreateImpassableSquareType() {
			final Position position = new Position(2, 2);
			final Square square = Square.createImpassableSquare(position);
			final Class<Square> expected = Square.class;
			final String errMsg = "Should return a Square instance";

			final Class<?> actual = square.getClass();

			assertEquals(expected, actual, errMsg);
		}

		// 2.a Test colour
		@Test
		void testCreateImpassableSquareColour() {
			for (int i = 0; i < 100; ++i) {
				final String errMsg = "Colour should be Colour.NONE";
				final Colour none = Colour.NONE;

				final Position position = new Position(2, 2);
				final Square square = Square.createImpassableSquare(position);
				final Colour colour = square.myColour;

				assertTrue(colour == none, errMsg);
			}
		}

		// 2.b Test symbol
		@Test
		void testCreateImpassableSquareSymbol() {
			for (int i = 0; i < 100; ++i) {
				final String errMsg = "Symbol should be Symbol.NONE";
				final Symbol none = Symbol.NONE;

				final Position position = new Position(2, 2);
				final Square square = Square.createImpassableSquare(position);
				final Symbol symbol = square.mySymbol;

				assertTrue(symbol == none, errMsg);
			}
		}
	}

	// 13. The game can check whether two squares have the same colour
	@Nested
	class testIsSameColour {
		Position position = new Position(1, 1);
		ArrayList<Square> squares1;
		Symbol symbol = Symbol.NONE;

		@BeforeEach
		void beforeEach() {
			Colour[] colours1 = new Colour[] { Colour.NONE, Colour.BLUE, Colour.YELLOW, Colour.GREEN, Colour.RED,
					Colour.PURPLE };
			squares1 = new ArrayList<Square>();
			for (int i = 0; i < colours1.length; i++) {
				squares1.add(new Square(position, false, colours1[i], symbol));
			}
		}

		// 13.a. Has the same colour
		@Test
		void testSameColour() {
			final String errMsg = "Colour comparison result should be true";
			Colour[] colours2 = new Colour[] { Colour.NONE, Colour.BLUE, Colour.YELLOW, Colour.GREEN, Colour.RED,
					Colour.PURPLE };
			ArrayList<Square> squares2 = new ArrayList<Square>();
			for (int i = 0; i < colours2.length; i++) {
				squares2.add(new Square(position, false, colours2[i], symbol));
			}

			for (int i = 0; i < squares1.size(); i++) {
				Square square1 = squares1.get(i);
				Square square2 = squares2.get(i);
				boolean expected = true;

				boolean actual = square1.isSameColour(square2);

				assertEquals(expected, actual, errMsg);
			}
		}

		// 13.b. Has different colours
		@Test
		void testDifferentColour() {
			final String errMsg = "Colour comparison result should be false";
			Colour[] colours2 = new Colour[] { Colour.PURPLE, Colour.NONE, Colour.BLUE, Colour.YELLOW, Colour.GREEN,
					Colour.RED };
			ArrayList<Square> squares2 = new ArrayList<Square>();
			for (int i = 0; i < colours2.length; i++) {
				squares2.add(new Square(position, false, colours2[i], symbol));
			}

			for (int i = 0; i < squares1.size(); i++) {
				Square square1 = squares1.get(i);
				Square square2 = squares2.get(i);
				boolean expected = false;

				boolean actual = square1.isSameColour(square2);

				assertEquals(expected, actual, errMsg);
			}
		}

	}
	// 14. The game can check whether two squares have the same symbol
	@Nested
	class testIsSameSymbol {
		Position position = new Position(1, 1);
		ArrayList<Square> squares1;
		Colour colour = Colour.NONE;

		@BeforeEach
		void beforeEach() {
			Symbol[] symbols1 = new Symbol[] { Symbol.NONE, Symbol.CROSS, Symbol.STAR, Symbol.DIAMOND, Symbol.FLOWER,
					Symbol.THUNDERBOLT };
			squares1 = new ArrayList<Square>();
			for (int i = 0; i < symbols1.length; i++) {
				squares1.add(new Square(position, false, colour, symbols1[i]));
			}
		}

		// 14.a. Has the same symbol
		@Test
		void testSameSymbol() {
			final String errMsg = "Symbol comparison result should be true";
			Symbol[] symbols2 = new Symbol[] { Symbol.NONE, Symbol.CROSS, Symbol.STAR, Symbol.DIAMOND, Symbol.FLOWER,
					Symbol.THUNDERBOLT };
			ArrayList<Square> squares2 = new ArrayList<Square>();
			for (int i = 0; i < symbols2.length; i++) {
				squares2.add(new Square(position, false, colour, symbols2[i]));
			}

			for (int i = 0; i < squares1.size(); i++) {
				Square square1 = squares1.get(i);
				Square square2 = squares2.get(i);
				boolean expected = true;

				boolean actual = square1.isSameSymbol(square2);

				assertEquals(expected, actual, errMsg);
			}
		}

		// 14.b. Has different symbols
		@Test
		void testDifferentSymbol() {
			final String errMsg = "Symbol comparison result should be false";
			Symbol[] symbols2 = new Symbol[] { Symbol.THUNDERBOLT, Symbol.NONE, Symbol.CROSS, Symbol.STAR,
					Symbol.DIAMOND, Symbol.FLOWER };
			ArrayList<Square> squares2 = new ArrayList<Square>();
			for (int i = 0; i < symbols2.length; i++) {
				squares2.add(new Square(position, false, colour, symbols2[i]));
			}

			for (int i = 0; i < squares1.size(); i++) {
				Square square1 = squares1.get(i);
				Square square2 = squares2.get(i);
				boolean expected = false;

				boolean actual = square1.isSameSymbol(square2);

				assertEquals(expected, actual, errMsg);
			}
		}

	}

	@Test
	void testIsSamePosition() {
		final String errMsg = "Wrong position comparison result";
		Random r = new Random();

		for (int i = 0; i < 100; i++) {
			// Arrange
			Position position1 = new Position(i, i);
			Position position2 = new Position(r.nextInt(100), r.nextInt(100));
			final Square square1 = new Square(position1, false, Colour.getRandomColour(), Symbol.getRandomSymbol());
			final int x1 = square1.myPosition.X;
			final int y1 = square1.myPosition.Y;

			final Square square2 = new Square(position2, false, Colour.getRandomColour(), Symbol.getRandomSymbol());
			final int x2 = square2.myPosition.X;
			final int y2 = square2.myPosition.Y;

			boolean expected = x1 == x2 && y1 == y2;

			// Act
			boolean actual = square1.isSamePosition(square2.myPosition);

			assertEquals(expected, actual, errMsg);
		}
	}

}
