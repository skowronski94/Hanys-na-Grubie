package board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import game_controller.GameController;
import memento.Memento;

public class BoardPanel extends JPanel {
	
	private int widthInTiles = 10;
	private int heightInTiles = 10;
	private int tileWidth;
	private int tileHeight;
	private int widthMargin;
	private int heightMargin;
	private Board board;
	
	// public ///////////////////////////////////
	public void initialize() {
		tileWidth = this.getWidth() / widthInTiles;
		tileHeight = this.getHeight() / heightInTiles;
		widthMargin = getWidth() % (widthInTiles * tileWidth);
		heightMargin = this.getHeight() % (heightInTiles * tileHeight);
		board = new Board(widthInTiles, heightInTiles, tileWidth, tileHeight);
		GameController.getInstance().setBoard(board);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		board.draw(g2);
	}
	
	// constructors /////////////////////////////
	public BoardPanel(int widthInTiles, int heightInTiles) {
		this.widthInTiles = widthInTiles;
		this.heightInTiles = heightInTiles;
		this.setBackground(Color.BLACK);
		addMouseListener(new MouseBoard());
		
		InputMap imap = this.getInputMap(JComponent.WHEN_FOCUSED);
		imap.put(KeyStroke.getKeyStroke("ctrl Z"), "backup");
		
		ActionMap amap = this.getActionMap(); 
		amap.put("backup", new BackupAction());
	}
	
	private class BackupAction extends AbstractAction
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("ctrl Z");
			GameController gc = GameController.getInstance();
			if(!gc.getCareTaker().isListEmpty()) {
				System.out.println("In");
				Memento m = gc.getCareTaker().pop();
				board.get(m.getX(), m.getY()).unsetBuilding();
				gc.getStateFromMemento(m);
				repaint();
			}
		}
	}

	private class MouseBoard extends MouseAdapter
	{		
		public void mousePressed(MouseEvent e)
		{
			Point p = e.getPoint();
			int x = p.x / tileWidth;
			int y = p.y / tileHeight;
			if(x >= widthInTiles || y >= heightInTiles)
				return;
			if(!board.get(x, y).hasBuilding()){
				GameController  gc = GameController.getInstance();
				if (gc.getGold() - GameController.costMap.get(gc.getToBuild()) > 0) {
					gc.getCareTaker().add(gc.saveStateToMemento(x, y, gc.getToBuild()));
					board.get(x, y).setBuilding(gc.getToBuild());
				}		
			}
			repaint();
		}
	}
}
