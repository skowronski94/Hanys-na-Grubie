package board;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import interfaces.IDrawable;
import interfaces.IObserver;
import tile.Tile;

public class Board implements IDrawable, IObserver{

	private List<List<Tile> > tileSet;
	
	// public ///////////////////////////////////
	public void forEach(Consumer<? super Tile> action) {
		tileSet.forEach(row -> row.forEach(tile -> action.accept(tile)));
	}
	
	public Tile get(int x, int y) {
		if(tileSet.size() <= x)
			return null;
		if(tileSet.get(x).size() <= y)
			return null;
		return tileSet.get(x).get(y);
	}
	
	@Override
	public void draw(Graphics2D g2) {
		tileSet.forEach(row -> row.forEach(tile -> tile.draw(g2)));
	}
	
	@Override
	public void update() {
		forEach(tile -> { if(tile.hasBuilding())
							tile.getBuilding().work();});
	}
	
	// constructors ////////////////////////////
	public Board(int width, int height, int tileWidth, int tileHeight) {
		tileSet = new ArrayList<>(width);
		for(int j = 0; j < width; j++) {
			tileSet.add(new ArrayList<>(height));
			for(int k = 0; k < height; k ++)
				tileSet.get(j).add(new Tile(j * tileWidth, k * tileHeight, tileWidth, tileHeight));
		}
	}
}
