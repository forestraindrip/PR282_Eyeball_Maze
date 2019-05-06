package nz.ac.ara.marcusJ;

public abstract class Controller {
	View view;
	State state;

	public Controller(View view, State state) {
		this.view = view;
		this.state = state;
	}

	abstract public void startGame();

	abstract public void showRoute();

	abstract public void showMaze();

	abstract public void showAvatar();

	abstract public void showMoveRecord();

	public void start() {
		startGame();
	}
	
	public void stop() {
		this.view.stop();
	}
	abstract public String saveMaze();
	abstract public void loadMaze(String strMaze);
	
	abstract public String saveState();
	abstract public void loadState(String strState);
}
