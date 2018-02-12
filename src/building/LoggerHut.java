package building;

import tile.TerrainType;

public class LoggerHut extends Building {

	public static final int COST = 1500;
	
	// private ///////////////////////////////////
		@Override
		protected int pay() {
			return 30;
		}

		@Override
		protected int produce() {
			return 330;
		}
		
	// constructors //////////////////////////////
	public LoggerHut(TerrainType terrain) {
		if(terrain == TerrainType.FOREST)
			terrainBonus = 50;
		type = BuildingType.LOGGER_HUT;
	}
}
