package building;

public enum BuildingType {
	LOGGER_HUT(0),
	LUMBERMILL(1),
	QUARRY(2),
	GOLD_MINE(3),
	MINT(4);
	
	public final int val;
    private BuildingType(int value) {
        this.val = value;
    }
}
