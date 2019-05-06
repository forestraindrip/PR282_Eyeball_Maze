package nz.ac.ara.marcusJ;

public class Position {
	protected int X;
	protected int Y;

	public Position(int x, int y) {
		this.X = x;
		this.Y = y;
	}

	@Override
	public String toString() {
		return "X: " + X + " Y: " + Y;
	}

}