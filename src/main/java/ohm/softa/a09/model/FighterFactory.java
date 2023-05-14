package ohm.softa.a09.model;

import ohm.softa.a09.model.empire.TieBomber;
import ohm.softa.a09.model.empire.TieFighter;
import ohm.softa.a09.model.empire.TieInterceptor;
import ohm.softa.a09.model.rebellion.AWing;
import ohm.softa.a09.model.rebellion.Flyweight;
import ohm.softa.a09.model.rebellion.XWing;
import ohm.softa.a09.model.rebellion.YWing;
import ohm.softa.a09.resource.FxImageLoaderAdapter;
import ohm.softa.a09.resource.ResourceLoader;
import ohm.softa.a09.util.NameGenerator;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Factory to create new fighters
 * Creates random fighters
 *
 * @author Peter Kurfer
 */
public final class FighterFactory {

	private static final int NumberOfKnownFighterTypes = 6;
	private final Random random;
	private final NameGenerator nameGenerator;
	private final FxImageLoaderAdapter imageResourceLoader;
	private Map<String, Flyweight> map= new HashMap<>();

	public FighterFactory() {
		nameGenerator = new NameGenerator();
		random = new Random();
		imageResourceLoader = new FxImageLoaderAdapter();
	}

	/**
	 * Create a random Fighter
	 *
	 * @implNote the method has an implementation flaw because it always loads the fighters image
	 * @return a new Fighter instance
	 */
	public Fighter createFighter() {
		switch (random.nextInt(NumberOfKnownFighterTypes)) {
			case 0:
				return new AWing(nameGenerator.generateName(), getFlyweight("fighter/awing.jpg").getImg());
			case 1:
				return new XWing(nameGenerator.generateName(), getFlyweight( "fighter/xwing.jpg").getImg());
			case 2:
				return new YWing(nameGenerator.generateName(), getFlyweight( "fighter/ywing.jpg").getImg());
			case 3:
				return new TieBomber(nameGenerator.generateName(), getFlyweight( "fighter/tiebomber.jpg").getImg());
			case 4:
				return new TieFighter(nameGenerator.generateName(), getFlyweight("fighter/tiefighter.jpg").getImg());
			default:
				return new TieInterceptor(nameGenerator.generateName(), getFlyweight("fighter/tieinterceptor.jpg").getImg());
		}
	}

	private Flyweight getFlyweight(String path){
		if(map.containsKey(path)){
			return map.get(path);
		}
		Flyweight fw = new Flyweight(imageResourceLoader.loadImage(path));
		map.put(path, fw);
		return fw;
	}
}
