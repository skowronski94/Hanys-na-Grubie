package building;

public class Mint extends Building {

	public static final int COST = 10000;
	
	// private ///////////////////////////////////
	@Override
	protected int pay() {
		return 300;
	}

	@Override
	protected int produce() {
		return 3000;
	}
	
	// constructors //////////////////////////////
	public Mint() {
		type = BuildingType.MINT;
	}
}
