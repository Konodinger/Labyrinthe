package frame.MenuBar;


import javax.swing.JMenuItem;

import Actions.ResolveAction;
import frame.MazeApp;

public class ResolveMenuItem extends JMenuItem {

	private final MazeApp app;
	
	public ResolveMenuItem(MazeApp app) {
		super("Résoudre");
		this.app = app;
		addActionListener(new ResolveAction(app));
		
	}

}
