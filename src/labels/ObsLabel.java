package labels;

import javax.swing.JLabel;

import game_controller.GameController;
import interfaces.IObserver;

public class ObsLabel extends JLabel implements IObserver {
	
	// public methods
	@Override
	public void update(){
		this.setText(Integer.toString(GameController.getInstance().getGold()));
	}
	
	// constructors
	public ObsLabel() {
		super();
	}
	
	public ObsLabel(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
	}

}
