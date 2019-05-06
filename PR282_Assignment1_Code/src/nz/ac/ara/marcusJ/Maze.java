package nz.ac.ara.marcusJ;

import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;

public class Maze {
	protected Square[][] mySquares;
	protected Square myStartSquare;
	protected ArrayList<Square> myCurrentGoals;
	protected ArrayList<Square> myFinishedGoals;
	protected ArrayList<Square> myRoute;
	protected int widthMaze;
	protected int heightMaze;

	// Constructor
	public Maze(int width, int height, Position positionStart, int amountGoals, int maxMove, Direction directionStart) {
		myCurrentGoals = new ArrayList<Square>();
		myFinishedGoals = new ArrayList<Square>();
		myRoute = new ArrayList<Square>();
		setMaze(width, height, positionStart, amountGoals, maxMove, directionStart);
	}

	protected void setMaze(int width, int height, Position positionStart, int amountGoals, int maxMove,
			Direction direction) {
		// set playing area
//		System.out.println("Set playing area");
		this.widthMaze = width >= 2 ? width : 2;
		this.heightMaze = height >= 2 ? height : 2;

		// create empty maze
//		System.out.println("create empty maze");
		this.mySquares = this.createEmptySquares(this.widthMaze, this.heightMaze);

		// set start
//		System.out.println("Building start square");
		this.setStartSquare(positionStart);

		// create route
//		System.out.println("Building route");
		this.myRoute = this.createRoute(this.widthMaze, this.heightMaze, this.myStartSquare, amountGoals, maxMove,
				direction);
		// set goals
//		System.out.println("set goals");
		this.createGoals(amountGoals);

		// fiil the maze
//		System.out.println("fiil empty area");
		this.fillEmptyArea();
	}

	protected void fillEmptyArea() {
		for (int y = 0; y < this.heightMaze - 1; y++) {
			for (int x = 0; x < this.widthMaze; x++) {
				Square square = this.mySquares[x][y];
				if (!square.isStart && !square.isGoal && !hasTheSquare(myRoute, square)) {
					this.mySquares[x][y] = Square.createPassableSquare(square.myPosition);
				}
			}
		}
	}

	protected void setStartSquare(Position position) {
		int x = position.X;
		int y = position.Y;

		mySquares[x][y] = Square.createPassableSquare(position);
		mySquares[x][y].isStart = true;
		this.myStartSquare = mySquares[x][y];
	}

	protected void createGoals(int amountGoals) {
		int indexLast = this.myRoute.size() - 1;
		int counter = 0;
		Random random = new Random();

		do {
			Square aGoal;
			if (counter == 0) {
				aGoal = this.myRoute.get(indexLast); // Set the last square in the route
			} else {
				do {
					// min~max step range => random.nextInt(max - min + 1) + min
					int indexRandom = random.nextInt((indexLast - 1) + 1) + 1;
					aGoal = this.myRoute.get(indexRandom);
				} while (aGoal.isGoal); // Until getting a square is not a goal
			}
			this.addAGoal(aGoal.myPosition);
			++counter;
		} while (counter < amountGoals);
	}

	protected Square[][] createEmptySquares(int widthMaze, int heightMaze) {
		Square[][] emptyMaze = new Square[widthMaze][heightMaze];
		for (int x = 0; x < widthMaze; ++x) {
			for (int y = 0; y < heightMaze; ++y) {
				emptyMaze[x][y] = Square.createImpassableSquare(new Position(x, y));
			}
		}
		return emptyMaze;
	}

	protected ArrayList<Square> createRoute(int widthMaze, int heightMaze, Square startSquare, int minMove, int maxMove,
			Direction directionStart) {

		// initialise
		ArrayList<Square> aRoute = new ArrayList<Square>();
		int counter = 0;
		Position positionCurrent = new Position(startSquare.myPosition.X, startSquare.myPosition.Y);
		Square currentSquare = mySquares[positionCurrent.X][positionCurrent.Y];
		Direction directionCurrent = directionStart;
		Square nextSquare;

		Random random = new Random();
		int moveLimit = random.nextInt(maxMove - minMove + 1) + minMove;
		do {
			// add the square to the route
			aRoute.add(currentSquare);
			Direction directionRandom;

			// Create a unidque random next square
			do {
				// get random direction
				do {
					// regenerate the direction if it is backward direction or will hit the wall
					directionRandom = Direction.getRandomDirection();
				} while (isOppositeDirection(directionCurrent, directionRandom)
						|| (directionRandom == Direction.UP && positionCurrent.Y == 0)
						|| (directionRandom == Direction.RIGHT && positionCurrent.X == widthMaze - 1)
						|| (directionRandom == Direction.DOWN && positionCurrent.Y == heightMaze - 1)
						|| (directionRandom == Direction.LEFT && positionCurrent.X == 0));
//				System.out.println("randomDirection " + randomDirection);

				// the range of step
				int range = this.generateRandomRange(directionRandom, positionCurrent, widthMaze, heightMaze);
				// get random step
				int step = random.nextInt(range) + 1;

				// find the next square
				nextSquare = this.findNextSquare(this, directionRandom, step, positionCurrent);
//				System.out.println(nextSquare);
			} while (hasTheSquare(aRoute, nextSquare) || nextSquare.isStart
					|| nextSquare.myPosition.Y == heightMaze - 1);

			// set valid square colour or symbol to the next square
			Position nextPosition = nextSquare.myPosition;
			while (!currentSquare.isSameColour(nextSquare) && !currentSquare.isSameSymbol(nextSquare)) {
				nextSquare = Square.createPassableSquare(nextPosition);
			}
			mySquares[nextPosition.X][nextPosition.Y] = nextSquare;

			// set the next square to be the current square
			directionCurrent = directionRandom;
			positionCurrent = new Position(nextPosition.X, nextPosition.Y);
			currentSquare = mySquares[positionCurrent.X][positionCurrent.Y];
			++counter;
		} while (counter <= moveLimit);
		return aRoute;
	}

	private boolean isOppositeDirection(Direction directionCurrent, Direction directionRandom) {
		boolean result = false;
		if ((Math.abs(directionRandom.ordinal() - directionCurrent.ordinal()) == 2)) {
			result = true;
		}
//		System.out.println(directionCurrent + " " + directionRandom + " " + result);
		return result;
	}

	protected boolean hasTheSquare(ArrayList<Square> arraySquares, Square nextSquare) {
		boolean result = false;
		for (int i = 0; i < arraySquares.size(); ++i) {
			Square square = arraySquares.get(i);
			if (square.isSamePosition(nextSquare.myPosition)) {
				result = true;
				break;
			}
		}
//		System.out.print(result + "\r\n");
		return result;
	}

	protected int generateRandomRange(Direction randomDirection, Position positionCurrent, int widthMaze,
			int heightMaze) {
		int range = 0;
		int xCurrentPos = positionCurrent.X;
		int yCurrentPos = positionCurrent.Y;
		int indexLastX = widthMaze - 1;
		int indexLastY = heightMaze - 1;
		switch (randomDirection) {
		case UP:
			range = yCurrentPos;
			break;
		case RIGHT:
			range = indexLastX - xCurrentPos;
			break;
		case DOWN:
			range = indexLastY - yCurrentPos;
			break;
		case LEFT:
			range = xCurrentPos;
			break;
		default:
			break;
		}
//		System.out.println("range " + range);
		return range;
	}

	protected Square findNextSquare(Maze maze, Direction direction, int step, Position positionCurrent) {
		int xCurrentPos = positionCurrent.X;
		int yCurrentPos = positionCurrent.Y;
		Square nextSquare = mySquares[xCurrentPos][yCurrentPos];
		switch (direction) {
		case UP:
			nextSquare = mySquares[xCurrentPos][yCurrentPos - step];
			break;
		case RIGHT:
			nextSquare = mySquares[xCurrentPos + step][yCurrentPos];
			break;
		case DOWN:
			nextSquare = mySquares[xCurrentPos][yCurrentPos + step];
			break;
		case LEFT:
			nextSquare = mySquares[xCurrentPos - step][yCurrentPos];
			break;
		default:
			break;
		}
		return nextSquare;
	}

	protected void addAGoal(Position position) {
		Square aGoal = this.mySquares[position.X][position.Y];
		aGoal.isGoal = true;
		this.myCurrentGoals.add(aGoal);
	}

	protected boolean removeACurrentGoal(Position position) {
		int x = position.X;
		int y = position.Y;
		boolean result = this.myCurrentGoals.removeIf(e -> ((e.myPosition.X == x) && (e.myPosition.Y == y)));
		return result;
	}

	public boolean isReachAGoal(Position position) {
		int x = position.X;
		int y = position.Y;
		Square squareCurrent = this.mySquares[x][y];
		boolean result = false;
		if (squareCurrent.isGoal) {
			result = true;
		}
		return result;
	}

	protected void reachAGoal(Position position) {
		int x = position.X;
		int y = position.Y;
		Square goal;
		for (Square square : this.myCurrentGoals) {
			if (square.myPosition.X == x && square.myPosition.Y == y) {
				goal = square;
				this.myFinishedGoals.add(goal);
				this.removeACurrentGoal(position);
				break;
			}
		}
	}

	public int countRemainingGoals() {
		return this.myCurrentGoals.size();
	}

	public String saveMaze() {
		Gson gson = new Gson();
		String output = gson.toJson(this);
		return output;
	}

	public static Maze loadMaze(String aString) {
		Gson gson = new Gson();
		Maze maze = gson.fromJson(aString, Maze.class);
		return maze;
	}

}
