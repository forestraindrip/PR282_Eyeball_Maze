package nz.ac.ara.marcusJ;

import com.google.gson.Gson;

public abstract class Element {
	protected Position myPosition;

	public Element(Position position) {
		this.myPosition = position;
	}

	public String save() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

}
