package frame.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import frame.MazeApp;

public class QuitMenuItem extends JMenuItem implements ActionListener {

	private final MazeApp app;
	
	public QuitMenuItem(MazeApp app) {
		super("Quitter");
		this.app = app;
		addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ev) {
		System.exit(0);
	}
}
