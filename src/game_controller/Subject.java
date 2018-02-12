package game_controller;

import java.util.List;
import interfaces.IObserver;

public abstract class Subject {

	protected List<IObserver> obsList;
	protected IObserver board;
	
	// protected
	protected abstract void notifyObs();
	protected abstract void notifyBoard();
}
