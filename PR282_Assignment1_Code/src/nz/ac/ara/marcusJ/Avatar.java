package nz.ac.ara.marcusJ;

import com.google.gson.Gson;

public class Avatar extends Element{
	protected String myName;
	
	protected Direction myDirection;

	public Avatar(String name, Position position, Direction direction) {
		super(position);
		this.setAvatar(name, position, direction);
	}

	protected void setAvatar(String name, Position position, Direction direction) {
		this.myName = name;
		this.myPosition = position;
		this.myDirection = direction;
	}

	public Avatar moveUp(int step) {
		this.myPosition = new Position(this.myPosition.X, this.myPosition.Y - step);
		this.myDirection = Direction.UP;
		return this;
	}

	public Avatar moveDown(int step) {
		this.myPosition = new Position(this.myPosition.X, this.myPosition.Y + step);
		this.myDirection = Direction.DOWN;
		return this;
	}

	public Avatar moveLeft(int step) {
		this.myPosition = new Position(this.myPosition.X - step, this.myPosition.Y);
		this.myDirection = Direction.LEFT;
		return this;
	}

	public Avatar moveRight(int step) {
		this.myPosition = new Position(this.myPosition.X + step, this.myPosition.Y);
		this.myDirection = Direction.RIGHT;
		return this;
	}

	 static public Avatar load(String input) {
		Gson gson = new Gson();
		return gson.fromJson(input, Avatar.class);
	}
}
