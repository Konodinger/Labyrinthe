package frame.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Actions.NewAction;
import frame.MazeApp;

public class NewMenuItem extends JMenuItem {
		
	private final MazeApp app;
	
	public NewMenuItem(MazeApp app) {
		super("Nouveau");
		this.app = app;
		addActionListener(new NewAction(app));
		
	}
}
