package frame.MenuBar;

import javax.swing.JMenuItem;

import Actions.NewAction;
import frame.MazeApp;

public class NewMenuItem extends JMenuItem {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Crée un bouton de menu "Nouveau"
	 * @param app L'application en cours.
	 */
	public NewMenuItem(MazeApp app) {
		super("Nouveau");
		this.app = app;
		addActionListener(new NewAction(app));
		
	}
}
