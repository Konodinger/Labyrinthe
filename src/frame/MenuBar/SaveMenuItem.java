package frame.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import frame.MazeApp;

public class SaveMenuItem extends JMenuItem implements ActionListener {

	private final MazeApp app;
	
	public SaveMenuItem(MazeApp app) {
		super("Sauvegarder");
		this.app = app;
		addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}
