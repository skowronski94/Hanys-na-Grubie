package memento;

import java.util.LinkedList;

public class CareTaker {
	
    private LinkedList<Memento> mementoList;

    // public ////////////////////////////////////
    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int i) {
        return mementoList.get(i);
    }
    
    public Memento pop() {
        Memento m = mementoList.getLast();
        mementoList.removeLast();
        return m;
    }
    
    public boolean isListEmpty() {
    	return mementoList.isEmpty();
    }
   
    // constructors //////////////////////////////
    public CareTaker() {
    	mementoList = new LinkedList<>();
    }
}