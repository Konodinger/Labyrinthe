package frame.MenuBar;


import javax.swing.JMenuItem;

import Actions.ResolveAction;
import frame.MazeApp;

public class ResolveMenuItem extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Crée un bouton de menu "Résoudre"
	 * @param app L'application en cours.
	 */
	public ResolveMenuItem(MazeApp app) {
		super("Résoudre");
		this.app = app;
		addActionListener(new ResolveAction(app));
		
	}

}
