package nz.ac.ara.marcusJ;

import java.util.ArrayList;

import com.google.gson.Gson;

public class State {
	protected Avatar myAvatar;
	protected ArrayList<String> mySaves;
	protected Maze myMaze;
	protected boolean isFinished;
	protected String stringOriginalMaze;

	public State(String namePlayer, int widthMaze, int heightMaze, int xStart, int yStart, int amountGoals, int maxMove,
			Direction directionStart) {
//		System.out.println("set start position");
		Position positionStart = new Position(xStart, yStart);
//		System.out.println("Building maze");
		this.myMaze = new Maze(widthMaze, heightMaze, positionStart, amountGoals, maxMove, directionStart);
//		System.out.println("Building avatar");
		this.myAvatar = new Avatar(namePlayer, positionStart, directionStart);
		this.mySaves = new ArrayList<String>();
		this.recordMove(myAvatar, myMaze.myStartSquare);
		this.isFinished = false;

		Gson gson = new Gson();
		this.stringOriginalMaze = gson.toJson(myMaze);
	}

	public void moveAvatar(Position position) throws Exception {
		int x = position.X;
		int y = position.Y;

		Position positionAvatar = this.myAvatar.myPosition;
		Square squareAvatar = myMaze.mySquares[positionAvatar.X][positionAvatar.Y];
		Square squareTarget = myMaze.mySquares[x][y];
		// check position is on the same x or y axis
		boolean isOnTheSameAxis = this.isOnTheSameAxis(position);
		// check is not exceed the boundary
		boolean isExceedeBoundary = this.isExceedeBoundary(position);
		// check is not the same square
		boolean isTheSameSquare = this.isTheSameSquare(squareAvatar, squareTarget);
		// check colour
		boolean isSameColour = squareAvatar.isSameColour(squareTarget);
		// check symbol
		boolean isSameSymbol = squareAvatar.isSameSymbol(squareTarget);
		// check is not move backward
		boolean isMoveBackward = this.isMoveBackward(this.myAvatar, position);

		boolean isLegalMove = isOnTheSameAxis && !isExceedeBoundary && !isMoveBackward && !isTheSameSquare
				&& (isSameColour || isSameSymbol);

		if (isLegalMove) {

			if (squareAvatar.isGoal) {
				this.myMaze.mySquares[squareAvatar.myPosition.X][squareAvatar.myPosition.Y] = Square
						.createImpassableSquare(positionAvatar);
			}
			int xDistance = x - this.myAvatar.myPosition.X;
			int yDistance = y - this.myAvatar.myPosition.Y;

			int distance;
			if (xDistance == 0 && yDistance < 0) {
				// go up
				distance = Math.abs(yDistance);
				this.myAvatar = this.myAvatar.moveUp(distance);
			} else if (xDistance > 0 && yDistance == 0) {
				// go right
				distance = Math.abs(xDistance);
				this.myAvatar = this.myAvatar.moveRight(distance);
			} else if (xDistance == 0 && yDistance > 0) {
				// go down
				distance = Math.abs(yDistance);
				this.myAvatar = this.myAvatar.moveDown(distance);
			} else if (xDistance < 0 && yDistance == 0) {
				// go left
				distance = Math.abs(xDistance);
				this.myAvatar = this.myAvatar.moveLeft(distance);
			}

			if (this.myMaze.isReachAGoal(this.myAvatar.myPosition)) {
				this.myMaze.reachAGoal(this.myAvatar.myPosition);
			}
			if (this.allGoalsCleared()) {
				this.isFinished = true;
			}
			Square squareCurrent = myMaze.mySquares[myAvatar.myPosition.X][myAvatar.myPosition.Y];
			this.recordMove(this.myAvatar, squareCurrent);

		} else if (!isOnTheSameAxis) {
			throw new NotTheSameAxisException("New position must be on the same X or Y axis");
		} else if (isExceedeBoundary) {
			throw new ExceedeMazeBoundaryException("New position exceede the border");
		} else if (isTheSameSquare) {
			throw new MoveToSameSquareException("Sould move to a different square");
		} else if (isMoveBackward) {
			throw new MoveBackwardExecption("Avatar cannot move back");
		} else if (!isSameColour) {
			throw new DifferentColourException("Different Colour");
		} else if (!isSameSymbol) {
			throw new DifferentSymbolException("Different Symbol");
		}

//		System.out.println("x:"+ myAvatar.myPosition.X + " y:"+ myAvatar.myPosition.Y + " Dir:"+ myAvatar.myDirection );
	}

	protected boolean isOnTheSameAxis(Position positionNew) {
		Position positionAvatar = this.myAvatar.myPosition;
		return (Math.abs(positionAvatar.X - positionNew.X) == 0 || Math.abs(positionAvatar.Y - positionNew.Y) == 0);
	}

	protected boolean isExceedeBoundary(Position positionNew) {
		return (positionNew.X >= myMaze.widthMaze || positionNew.Y >= myMaze.heightMaze || positionNew.X < 0
				|| positionNew.Y < 0);
	}

	protected boolean isTheSameSquare(Square squareCurrent, Square squareTarget) {
		return squareCurrent.isSamePosition(squareTarget.myPosition);
	}

	protected boolean isMoveBackward(Avatar avatar, Position target) {
		Direction directionAvatar = avatar.myDirection;
		Position positionAvatar = avatar.myPosition;
		boolean result = false;
		if ((directionAvatar == Direction.UP && positionAvatar.Y < target.Y)
				|| (directionAvatar == Direction.RIGHT && positionAvatar.X > target.X)
				|| (directionAvatar == Direction.DOWN && positionAvatar.Y > target.Y)
				|| (directionAvatar == Direction.LEFT && positionAvatar.X < target.X)) {
			result = true;
		}
		return result;
	}

	protected void recordMove(Avatar avatar, Square square) {
		String jsonAvatar = avatar.save();
		String jsonSquare = square.save();

		String arrayString = "";
		arrayString = jsonAvatar + ";;" + jsonSquare;

		this.mySaves.add(arrayString);
//		System.out.println(arrayString);
	}

	public void undoLastMove() throws NoSaveException {
		if (this.mySaves.size() <= 1) { // save[0] is the start
			throw new NoSaveException("No available save");
		}
		// Get the second last save(avatar at the previous square)
		int indexPreviousMove = this.mySaves.size() - 2;
		// System.out.println(indexPreviousMove);
		String[] previousSave = this.mySaves.get(indexPreviousMove).split(";;");
		String strSquarePrevious = previousSave[1];
		Square previousSquare = Square.load(strSquarePrevious);

		Position previousSquarePosition = previousSquare.myPosition;
		// recover the square to the previous state
		this.myMaze.mySquares[previousSquarePosition.X][previousSquarePosition.Y] = previousSquare;

		String strAvatarPrevious = previousSave[0];
		Avatar lastAvatar = Avatar.load(strAvatarPrevious);
		this.myAvatar = lastAvatar;

		// Get the last save (avatar at the current square)
		int indexCurrentMove = this.mySaves.size() - 1;
		String[] currentSave = this.mySaves.get(indexCurrentMove).split(";;");
		String strSquareCurrent = currentSave[1];
		Square currentSquare = Square.load(strSquareCurrent);

		// If the current square is a goal then remove it from the list of finish goals
		if (currentSquare.isGoal) {
			this.myMaze.myFinishedGoals.removeIf(e -> ((e.myPosition.X == currentSquare.myPosition.X)
					&& (e.myPosition.Y == currentSquare.myPosition.Y)));
			this.myMaze.addAGoal(currentSquare.myPosition);
		}

		// remove the save
		this.mySaves.remove(indexCurrentMove);
	}

	protected boolean allGoalsCleared() {
		boolean result = false;
		if (this.myMaze.countRemainingGoals() == 0) {
			result = true;
		}
		return result;
	}

	public String getMoveRecord() {
		Gson gson = new Gson();
		String output = "";
		for (int i = 0; i < this.mySaves.size(); ++i) {
			String[] save = this.mySaves.get(i).split(";;");
			String stringSquare = save[1];
			Square square = gson.fromJson(stringSquare, Square.class);
			Position position = square.myPosition;
			output += String.format("Move %1$s: X:%2$s Y: %3$s \r\n", i + 1, position.X, position.Y);
		}
		return output;
	}

	public ArrayList<Square> getMazeRoute() {
		return this.myMaze.myRoute;
	}

	public State restartGame() {

		Gson gson = new Gson();
		String strState = gson.toJson(this);
		State stateNew = gson.fromJson(strState, State.class);

		String[] firstSave = this.mySaves.get(0).split(";;");

//		System.out.println("Building avatar");
		String stringAvatar = firstSave[0];
		stateNew.myAvatar = Avatar.load(stringAvatar);

//		System.out.println("Building maze");
		String stringMaze = this.stringOriginalMaze;
		stateNew.myMaze = Maze.loadMaze(stringMaze);

		stateNew.mySaves = new ArrayList<String>();
		stateNew.recordMove(myAvatar, myMaze.myStartSquare);
		stateNew.isFinished = false;

		return stateNew;
	}

	public String saveMaze() {
		return this.myMaze.saveMaze();
	}

	public void loadMaze(String strMaze) {
		Maze newMaze;
		try {
			newMaze = Maze.loadMaze(strMaze);
			this.myMaze = newMaze;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String saveState() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	static public State loadState(String strState) {
		State newState;
		Gson gson = new Gson();
		newState = gson.fromJson(strState, State.class);
		return newState;

	}
}
