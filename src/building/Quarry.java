package building;

import tile.TerrainType;

public class Quarry extends Building {

	public static final int COST = 500;
	
	// private ///////////////////////////////////
		@Override
		protected int pay() {
			return 20;
		}

		@Override
		protected int produce() {
			return 220;
		}
		
	// constructors //////////////////////////////
	public Quarry(TerrainType terrain) {
		if(terrain == TerrainType.MOUNTAINS)
			terrainBonus = 100;
		type = BuildingType.QUARRY;
	}
}
