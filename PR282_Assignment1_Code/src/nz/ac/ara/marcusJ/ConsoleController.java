package nz.ac.ara.marcusJ;

import java.util.ArrayList;

import com.google.gson.Gson;

public class ConsoleController extends Controller {

	public ConsoleController(View view, State state) {
		super(view, state);
	}

	@Override
	public void startGame() {
		do {
//			Gson gson = new Gson();
//			System.out.println(gson.toJson(state));
			this.showMaze();
			// this.showAvatar();
			view.say("Enter x y, showmaze, showroute, showavatar, undo, showmoverecord");
			String input = view.get().toLowerCase();
			if (input.equals("")) {
				continue;
			} else if (input.equals("showmaze")) {
				this.showMaze();
			} else if (input.equals("showroute")) {
				this.showRoute();
			} else if (input.equals("showavatar")) {
				this.showAvatar();
			} else if (input.equals("showmoverecord")) {
				showMoveRecord();
			} else if (input.equals("undo")) {
				try {
					this.state.undoLastMove();
				} catch (NoSaveException e) {
					this.view.say(e.getMessage());
				}
			} else {
				String[] arrayInput = input.split(" ");
				if (arrayInput.length != 2) {
					view.say("Wrong input number format");
					continue;
				}
				int x = Integer.parseInt(arrayInput[0]);
				int y = Integer.parseInt(arrayInput[1]);

				Position positionNew = new Position(x, y);
				try {
					state.moveAvatar(positionNew);
				} catch (Exception e) {
					view.say(e.getMessage());
				}
			}

			if (state.isFinished) {
				view.say("You win!");
				view.stop();
				break;
			}
		} while (!state.isFinished);

	}

	@Override
	public void showRoute() {
		ArrayList<Square> theRoute = this.state.getMazeRoute();
		int counter = 0;
		for (Square square : theRoute) {
			++counter;
			String message = counter + "- x:" + square.myPosition.X + " y:" + square.myPosition.Y;
			message += " colour: " + square.myColour + " symbol:" + square.mySymbol;
			message += " s: " + square.isStart + " g:" + square.isGoal;
			view.say(message);
		}
	}

	@Override
	public void showMaze() {
		String output = "";
		for (int y = 0; y < this.state.myMaze.heightMaze; y++) {
			for (int x = 0; x < this.state.myMaze.widthMaze; x++) {
				Square square = this.state.myMaze.mySquares[x][y];
				if (square.isSamePosition(this.state.myAvatar.myPosition)) {
					output += "*";
				}
				output += square.toString() + " ";
			}
			output += "\r\n";
		}
		this.view.say(output);
	}

	@Override
	public void showAvatar() {
		this.view.say("Avatar x:" + state.myAvatar.myPosition.X + " y:" + state.myAvatar.myPosition.Y + " Dir:"
				+ state.myAvatar.myDirection);
	}

	@Override
	public void showMoveRecord() {
		view.say(this.state.getMoveRecord());
	}

	@Override
	public String saveMaze() {
		return this.state.myMaze.saveMaze();
	}

	@Override
	public void loadMaze(String maze) {
		this.state.myMaze = Maze.loadMaze(maze);
	}

	@Override
	public String saveState() {
		return this.saveState();
	}

	@Override
	public void loadState(String strState) {
		this.state = State.loadState(strState);
	}

}
