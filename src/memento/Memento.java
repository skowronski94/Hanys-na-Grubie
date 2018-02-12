package memento;

import building.BuildingType;

public class Memento {
		private int x;
		private int y;
	    private BuildingType type;
	    private int gold;
 
	    // public ///////////////////////////////
	    public int getX(){
		       return x;
		}
	    
	    public int getY(){
		       return y;
	    }
	    
	    public BuildingType getBuildingType(){
		       return type;
	    }
	    
	    public int getGold(){
		       return gold;
	    }
	    
	    // constructors /////////////////////////
	    public Memento(int x, int y, BuildingType type, int gold){
	    	this.x = x;
	    	this.y = y;
	    	this.type = type;
	        this.gold = gold;
	    }	
	}