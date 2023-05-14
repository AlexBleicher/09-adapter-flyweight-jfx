package ohm.softa.a09.resource;

import javafx.scene.image.Image;

public class FxImageLoaderAdapter {

	private ResourceLoader<Image> resourceLoader = new ResourceLoader<>(Image::new);

	public Image loadImage(String p){
		return resourceLoader.loadResource(ClassLoader.getSystemClassLoader(), p);
	}
}
