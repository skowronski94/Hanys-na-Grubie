package window;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import board.BoardPanel;
import buttons.ButtonPanel;
import game_controller.GameController;
import labels.LabelPanel;


public class GamePanel extends JPanel {
	
	BoardPanel board;
	GameController gc;
	
	// public
	public void initialize() {
		board.initialize();
	}
	
	// constructors
	public GamePanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		
		board = new BoardPanel(10, 10);
		add(board, BorderLayout.CENTER);
		add(new ButtonPanel(), BorderLayout.SOUTH);
		add(new LabelPanel(), BorderLayout.NORTH);
		gc = GameController.getInstance();
	}
}
