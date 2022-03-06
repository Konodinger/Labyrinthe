package frame.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Actions.QuitAction;
import frame.MazeApp;

public class QuitMenuItem extends JMenuItem {

	private final MazeApp app;
	
	public QuitMenuItem(MazeApp app) {
		super("Quitter");
		this.app = app;
		addActionListener(new QuitAction(app));
		
	}
}
