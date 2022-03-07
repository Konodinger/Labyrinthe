package frame.MenuBar;

import javax.swing.JMenuItem;

import Actions.SaveAction;
import frame.MazeApp;

public class SaveMenuItem extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Crée un bouton de menu "Sauvegarder"
	 * @param app L'application en cours.
	 */
	public SaveMenuItem(MazeApp app) {
		super("Sauvegarder");
		this.app = app;
		addActionListener(new SaveAction(app));
		
	}
}
