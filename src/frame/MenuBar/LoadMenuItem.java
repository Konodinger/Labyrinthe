package frame.MenuBar;

import javax.swing.JMenuItem;

import Actions.LoadAction;
import frame.MazeApp;

public class LoadMenuItem extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Crée un bouton de menu "Charger"
	 * @param app L'application en cours.
	 */
	public LoadMenuItem(MazeApp app) {
		super("Charger");
		this.app = app;
		addActionListener(new LoadAction(app));
		
	}

}
