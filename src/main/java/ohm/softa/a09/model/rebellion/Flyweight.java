package ohm.softa.a09.model.rebellion;

import javafx.scene.image.Image;

public class Flyweight {

	private final Image img;

	public Flyweight(Image img){
		this.img = img;
	}

	public Image getImg() {
		return img;
	}
}
