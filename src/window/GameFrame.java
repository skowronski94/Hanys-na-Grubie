package window;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

	private final int WIDTH_UNIT_TIMES = 12;
	private final int HEIGHT_UNIT_TIMES = 12;
	private GamePanel gamePanel;
	
	// constructors
	public GameFrame(int unit) throws IOException{
		int windowWidth = WIDTH_UNIT_TIMES * unit;
		int windowHeight = HEIGHT_UNIT_TIMES * unit;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(windowWidth, windowHeight);
		setLocation((screenSize.width - windowWidth) / 2, (screenSize.height - windowHeight) / 2);
		GamePanel gamePanel = new GamePanel();
		setContentPane(gamePanel);
		
		setTitle("Pacman");
		setVisible(true);
		
		gamePanel.initialize();
	}
}