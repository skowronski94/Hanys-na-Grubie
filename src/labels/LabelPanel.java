package labels;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game_controller.GameController;

public class LabelPanel extends JPanel {

	public LabelPanel() {
		this.setLayout(new GridLayout(1, 0));
		this.setBackground(Color.WHITE);
		/*add(new JLabel("Drewno  ", SwingConstants.RIGHT));
		ObsLabel l = new ObsLabel("-", SwingConstants.LEFT, "wood");
		add(l);
		add(new JLabel("Kamynie  ", SwingConstants.RIGHT));
		l = new ObsLabel("-", SwingConstants.LEFT, "stone");
		add(l);*/
		add(new JLabel("Z³oto  ", SwingConstants.RIGHT));
		ObsLabel l = new ObsLabel("2000", SwingConstants.LEFT);
		GameController.getInstance().addObs(l);
		add(l);
	}
}
