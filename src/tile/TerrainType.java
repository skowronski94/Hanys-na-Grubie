package tile;

import java.util.Random;

public enum TerrainType {
	PLAINS(0),
	FOREST(1),
	MOUNTAINS(2);
	
	static private Random generator = new Random();
	
	public final int val;
    private TerrainType(int value) {
        this.val = value;
    }
    
    public static TerrainType getRandomTerrain(){
    	switch(generator.nextInt(4))
    	{
    	case 1:
    		return TerrainType.FOREST;
    	case 2:
    		return TerrainType.MOUNTAINS;
    	}
		return TerrainType.PLAINS;
    }
}
