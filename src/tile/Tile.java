package tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import building.Building;
import building.BuildingType;
import building.GoldMine;
import building.LoggerHut;
import building.Lumbermill;
import building.Mint;
import building.Quarry;
import game_controller.GameController;
import interfaces.IDrawable;

public class Tile implements IDrawable{

	private int x;
	private int y;
	private int width;
	private int height;
	private TerrainType terrain;
	private Building building;
	
	public static final Map<TerrainType, Color> colorMap;
	static {
        Map<TerrainType, Color> map = new HashMap<>(5);
        map.put(TerrainType.PLAINS, new Color(.2f ,.7f ,.0f));
		map.put(TerrainType.FOREST, new Color(.2f ,.4f ,.0f));
		map.put(TerrainType.MOUNTAINS, new Color(.3f ,.3f ,.3f));
        colorMap = Collections.unmodifiableMap(map);
    }
	
	// public //////////////////////////////
	public boolean hasBuilding() {
		if(building == null)
			return false;
		return true;
	}
	
	public Building getBuilding() {
		return building;
	}
	
	public boolean setBuilding(BuildingType type) {
		GameController gc = GameController.getInstance();
		if(gc.getGold() < 0 )
			return false;
		switch(type) {
		case LOGGER_HUT:
			building = new LoggerHut(terrain);
			gc.incBuildingsMap(BuildingType.LOGGER_HUT);
			gc.addGold(- GameController.costMap.get(BuildingType.LOGGER_HUT));
			return true;
		case LUMBERMILL:
			building = new Lumbermill(terrain);
			gc.incBuildingsMap(BuildingType.LUMBERMILL);
			gc.addGold(- GameController.costMap.get(BuildingType.LUMBERMILL));
			return true;
		case QUARRY:
			building = new Quarry(terrain);
			gc.incBuildingsMap(BuildingType.QUARRY);
			gc.addGold(- GameController.costMap.get(BuildingType.QUARRY));
			return true;
		case GOLD_MINE:
			building = new GoldMine(terrain);
			gc.incBuildingsMap(BuildingType.GOLD_MINE);
			gc.addGold(- GameController.costMap.get(BuildingType.GOLD_MINE));
			return true;
		case MINT:
			building = new Mint();
			gc.incBuildingsMap(BuildingType.MINT);
			gc.addGold(- GameController.costMap.get(BuildingType.MINT));
			return true;
		}
		return false;
	}
	
	public void unsetBuilding() {
		building = null;
	}
	
	public TerrainType getTerrain() {
		return terrain;
	}
	
	@Override
	public void draw(Graphics2D g2) {
		g2.setColor(colorMap.get(terrain));
		g2.fillRect(x, y, width, height);
		g2.setColor(Color.BLACK);
		g2.drawRect(x, y, width, height);
		if(building != null)
			g2.drawImage(building.getImage(), x, y, width, height, null);
	}
	
	// constructors ////////////////////
	public Tile(int x, int y, int width, int height) {
		
		this.terrain = TerrainType.getRandomTerrain();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public Tile(int x, int y, int width, int height, TerrainType terrain) {
		this.terrain = terrain;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
}
