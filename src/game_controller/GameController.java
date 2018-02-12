package game_controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Timer;
import building.BuildingType;
import building.GoldMine;
import building.LoggerHut;
import building.Lumbermill;
import building.Mint;
import building.Quarry;
import interfaces.IObserver;
import memento.CareTaker;
import memento.Memento;

public class GameController extends Subject{
	
	private static GameController gc = new GameController();
	private CareTaker careTaker;
	private int gold;
	private Timer timer;
	private BuildingType toBuild;
	private Map<BuildingType, Integer> buildingsMap;
	
	public static final Map<BuildingType, Integer> costMap;
	static {
        Map<BuildingType, Integer> map = new HashMap<>(5);
        map.put(BuildingType.LOGGER_HUT, LoggerHut.COST);
		map.put(BuildingType.LUMBERMILL, Lumbermill.COST);
		map.put(BuildingType.QUARRY, Quarry.COST);
		map.put(BuildingType.GOLD_MINE, GoldMine.COST);
		map.put(BuildingType.MINT, Mint.COST);
        costMap = Collections.unmodifiableMap(map);
    }
	
	// protected //////////////////////////////////
	@Override
	protected void notifyObs() {
		if(!obsList.isEmpty())
			obsList.forEach(l -> l.update());
	}
	
	@Override
	protected void notifyBoard() {
		if(board != null)
			board.update();
	}
	
	// public /////////////////////////////////////////////
	public int getFromBuildingsMap(BuildingType type) {
		return buildingsMap.get(type);
	}
	
	public void setIntoBuildingsMap(BuildingType type, int value) {
		buildingsMap.remove(type);
		buildingsMap.put(type, value);	
	}
	
	public void incBuildingsMap(BuildingType type) {
		int x = buildingsMap.get(type);
		buildingsMap.remove(type);
		buildingsMap.put(type, x + 1);	
	}
	
	public void decBuildingsMap(BuildingType type) {
		int x = buildingsMap.get(type);
		buildingsMap.remove(type);
		buildingsMap.put(type, x - 1);	
	}
	
	public int getGold() {
		return gold;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public void addGold(int gold) {
		this.gold += gold;
	}
	
	public BuildingType getToBuild() {
		return toBuild;
	}
	
	public void setToBuild(BuildingType type) {
		toBuild = type;
	}
	
	public void addObs(IObserver obs) {
		obsList.add(obs);
	}
	
	public void setBoard(IObserver obs) {
		board = obs;
	}
	
	public Memento saveStateToMemento(int x, int y, BuildingType type){
	    return new Memento(x, y, type, gold);
	}

    public void getStateFromMemento(Memento memento){
        gold = memento.getGold();
        this.decBuildingsMap(memento.getBuildingType());
    }
	
    public CareTaker getCareTaker() {
    	return careTaker;
    }
    
    public static GameController getInstance(){
	 	return gc;
	 }
   
	// constructors /////////////////////////////
	private GameController() {
		careTaker = new CareTaker();
		toBuild = BuildingType.LOGGER_HUT;
		gold = 2000;
		obsList = new ArrayList<>(1);
		buildingsMap = new HashMap<>(5);
		buildingsMap.put(BuildingType.LOGGER_HUT, 0);
		buildingsMap.put(BuildingType.LUMBERMILL, 0);
		buildingsMap.put(BuildingType.QUARRY, 0);
		buildingsMap.put(BuildingType.GOLD_MINE, 0);
		buildingsMap.put(BuildingType.MINT, 0);
		timer = new Timer(1000, (e)->{ notifyBoard();
									   notifyObs();});
		timer.start();
	}
}
