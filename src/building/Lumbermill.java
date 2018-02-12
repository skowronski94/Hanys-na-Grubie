package building;

import tile.TerrainType;

public class Lumbermill extends Building {
	
	public static final int COST = 3000;
	
	// private ///////////////////////////////////
		@Override
		protected int pay() {
			return 50;
		}

		@Override
		protected int produce() {
			return 550;
		}
		
	// constructors //////////////////////////////
	public Lumbermill(TerrainType terrain) {
		if(terrain == TerrainType.FOREST)
			terrainBonus = 50;
		type = BuildingType.LUMBERMILL;
	}
}
