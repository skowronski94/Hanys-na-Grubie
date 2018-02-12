package building;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import game_controller.GameController;

public abstract class Building {

	protected BuildingType type;
	protected int terrainBonus;
	
	public static final Map<BuildingType, Image> imageMap;
	static {
        Map<BuildingType, Image> map = new HashMap<>(5);
        try {
	        map.put(BuildingType.LOGGER_HUT, ImageIO.read(new File(".\\images\\Axe.png")));
			map.put(BuildingType.LUMBERMILL, ImageIO.read(new File(".\\images\\Saw.png")));
			map.put(BuildingType.QUARRY, ImageIO.read(new File(".\\images\\Hammer.png")));
			map.put(BuildingType.GOLD_MINE, ImageIO.read(new File(".\\images\\Pickaxe.png")));
			map.put(BuildingType.MINT, ImageIO.read(new File(".\\images\\Coins.png")));
        } catch (IOException e) {
			e.printStackTrace();
		}
        imageMap = Collections.unmodifiableMap(map);
    }
	
	// private ////////////////////////////////////////
	protected abstract int pay();
	protected abstract int produce();
	
	// public /////////////////////////////////////////
	public Image getImage() {
		return imageMap.get(type);
	}
	
	public void work() {
		GameController gc = GameController.getInstance();
		gc.setGold(gc.getGold() + produce() + terrainBonus);
		gc.setGold(gc.getGold() - pay());
	}

	// constructors ///////////////////////////////////
	protected Building() {}
}
