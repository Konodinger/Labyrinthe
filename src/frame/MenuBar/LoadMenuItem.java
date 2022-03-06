package frame.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Actions.LoadAction;
import Actions.NewAction;
import frame.MazeApp;

public class LoadMenuItem extends JMenuItem {

	private final MazeApp app;
	
	public LoadMenuItem(MazeApp app) {
		super("Charger");
		this.app = app;
		addActionListener(new LoadAction(app));
		
	}

}
