package nz.ac.ara.marcusJ;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

class MazeTest {
	@Nested
	class testMaze {
		Maze aMaze;

		@BeforeEach
		void beforeEach() {
			Position position = new Position(0, 0);
			Direction direction = Direction.UP;
			aMaze = new Maze(10, 10, position, 2, 6,direction);
		}

		@Test
		void testMazeType() {
			final String errMsg = "Should return the amount of remaining goals";
			final Class<Maze> expected = Maze.class;

			final Class<?> actual = aMaze.getClass();

			assertEquals(expected, actual, errMsg);
		}

		@Test
		void testMazeHasMySquares() {
			final String errMsg = "Should have mySquares";
			final Class<Square[][]> expected = Square[][].class;

			final Class<?> actual = aMaze.mySquares.getClass();

			assertEquals(expected, actual, errMsg);
		}

		@Test
		void testMazeHasMyCurrentGoals() {
			final String errMsg = "Should have mySquares";
			final Class<Square[][]> expected = Square[][].class;

			final Class<?> actual = aMaze.mySquares.getClass();

			assertEquals(expected, actual, errMsg);
		}
	}

	@Test
	void testCountRemainingGoals() {
		final String errMsg = "Should return the amount of remaining goals";
		Direction direction = Direction.UP;
		Position position = new Position(0, 0);
		for (int i = 1; i <= 5; i++) {
//			System.out.println("i " + i);
			final Maze aMaze = new Maze(10, 10, position, i,6, direction);
			final int expected = i;

			final int actual = aMaze.countRemainingGoals();

			assertEquals(expected, actual, errMsg);
		}
	}

	@Nested
	class testSaveAndLoad {
		int SIZE = 10;
		String[] arrayString = new String[SIZE];
		Maze[] arrayMaze = new Maze[SIZE];

		@BeforeEach
		void beforeEach() {
			Gson gson = new Gson();
			for (int i = 0; i < SIZE; i++) {
				Position position = new Position(i, i);
				Direction direction = Direction.UP;
				Maze aMaze = new Maze(10, 10, position, 2, 6,direction);

				arrayMaze[i] = aMaze;
				String jsonMaze = gson.toJson(aMaze);
				arrayString[i] = jsonMaze;
			}
		}

//		20.	Save a maze to a string
//		20.a.	Test the string
		@Test
		void testSaveMaze() {
			final String errMsg = "Should return a correct stringified maze";

			for (int i = 0; i < SIZE; ++i) {
				final String expected = this.arrayString[i];

				final Maze aMaze = this.arrayMaze[i];
				final String actual = aMaze.saveMaze();

				assertEquals(expected, actual, errMsg);
			}
		}

//		21.	Load a maze from a string
//		21.a.	Test the maze content
		@Test
		void testLoadMaze() {
			final String errMsg = "Should return a correct Maze instance";

			for (int i = 0; i < SIZE; ++i) {
				Maze mazeOriginal = this.arrayMaze[i];

				final String json = this.arrayString[i];
				final Maze mazeLoaded = Maze.loadMaze(json);
				final boolean expected = true;

				boolean hasTheSameStartSquare = this.isTheSameSquare(mazeOriginal.myStartSquare,
						mazeLoaded.myStartSquare);
				boolean hasTheSameMySquares = hasTheSameMySquares(mazeOriginal, mazeLoaded);

				boolean hasTheSameMyCurrentGoals = isTheSameArraySquares(mazeOriginal.myCurrentGoals,
						mazeLoaded.myCurrentGoals);
				boolean hasTheSameFinishedGoals = isTheSameArraySquares(mazeOriginal.myFinishedGoals,
						mazeLoaded.myFinishedGoals);
				boolean hasTheSameMyRoute = isTheSameArraySquares(mazeOriginal.myRoute, mazeLoaded.myRoute);

				final boolean actual = hasTheSameStartSquare && hasTheSameMySquares && hasTheSameMyCurrentGoals
						&& hasTheSameFinishedGoals && hasTheSameMyRoute;

				assertEquals(expected, actual, errMsg);
			}

		}

		private boolean isTheSameArraySquares(ArrayList<Square> array1, ArrayList<Square> array2) {

			boolean result = true;

			for (int i = 0; i < array1.size(); i++) {
				if (!isTheSameSquare(array1.get(i), array2.get(i))) {
					result = false;
					break;
				}

			}
			return result;
		}

		private boolean isTheSameSquare(Square square1, Square square2) {
			boolean result = false;

			if ((square1.isStart == square2.isStart) && (square1.isGoal == square2.isGoal)
					&& (square1.isStart == square2.isStart)
					&& (square1.myColour == square2.myColour)
					&& (square1.mySymbol == square2.mySymbol)
					&& (square1.myPosition.X == square2.myPosition.X)
					&& (square1.myPosition.Y == square2.myPosition.Y)) {
				result = true;
			}

			return result;
		}

		private boolean hasTheSameMySquares(Maze mazeOriginal, Maze mazeLoaded) {
			boolean result = true;
			Square[][] squaresOriginal = mazeOriginal.mySquares;
			Square[][] squaresLoaded = mazeLoaded.mySquares;

			for (int x = 0; x < squaresOriginal.length; x++) {
				for (int y = 0; y < squaresOriginal[x].length; y++) {
					if (!isTheSameSquare(squaresOriginal[x][y], squaresLoaded[x][y])) {
						result = false;
						break;
					}
				}
			}
			return result;
		}

	}

}
