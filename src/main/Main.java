package main;
import java.awt.EventQueue;

import window.GameFrame;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try 
				{
					int unit = 64;
					GameFrame frame = new GameFrame(unit);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

}
