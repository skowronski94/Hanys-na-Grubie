package building;

import tile.TerrainType;

public class GoldMine extends Building {

	public static final int COST = 5000;
	
	// private ///////////////////////////////////
		@Override
		protected int pay() {
			return 100;
		}

		@Override
		protected int produce() {
			return 1000;
		}
		
	// constructors //////////////////////////////
	public GoldMine(TerrainType terrain) {
		if(terrain == TerrainType.MOUNTAINS)
			terrainBonus = 200;
		type = BuildingType.GOLD_MINE;
	}
}
