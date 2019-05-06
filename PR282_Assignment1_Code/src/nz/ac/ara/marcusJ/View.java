package nz.ac.ara.marcusJ;

import java.util.Scanner;

public class View {
	protected Scanner scanner;
	
	public View () {
		scanner = new Scanner(System.in);
	}
	
	public void say(String message) {
		System.out.println(message);
	}
	public String get() {
		return scanner.nextLine();
	}
	
	public void stop() {
		this.scanner.close();
	}
}
