package buttons;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import building.BuildingType;
import game_controller.GameController;
import interfaces.IObserver;

public class ButtonPanel extends JPanel implements IObserver {

	private JButton goldMineButton;
	private JButton mintButton;
	
	// public /////////////////////////////
	@Override
	public void update() {
		GameController gc = GameController.getInstance();
		if(		gc.getFromBuildingsMap(BuildingType.LOGGER_HUT) > 0 &&
				gc.getFromBuildingsMap(BuildingType.LUMBERMILL) > 0 &&
				gc.getFromBuildingsMap(BuildingType.QUARRY) > 0){
			goldMineButton.setEnabled(true);
			mintButton.setEnabled(true);
		}
	}
	
	// constructors /////////////////////////
	public ButtonPanel() {
		this.setLayout(new GridLayout(1, 0));
		this.setBackground(Color.RED);
		
		JButton b = new JButton("Chatka drwala");
		b.addActionListener(x -> GameController.getInstance().setToBuild(BuildingType.LOGGER_HUT));
		add(b);
		b = new JButton("Tartak");
		b.addActionListener(x -> GameController.getInstance().setToBuild(BuildingType.LUMBERMILL));
		add(b);
		b = new JButton("Kamienio³om");
		b.addActionListener(x -> GameController.getInstance().setToBuild(BuildingType.QUARRY));
		add(b);
		goldMineButton = new JButton("Gruba z³ota");
		goldMineButton.addActionListener(x -> GameController.getInstance().setToBuild(BuildingType.GOLD_MINE));
		add(goldMineButton);
		mintButton = new JButton("Mennica");
		mintButton.addActionListener(x -> GameController.getInstance().setToBuild(BuildingType.MINT));
		add(mintButton);
		
		goldMineButton.setEnabled(false);
		mintButton.setEnabled(false);
		
		GameController.getInstance().addObs(this);
	}
}
