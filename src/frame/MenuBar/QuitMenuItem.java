package frame.MenuBar;

import javax.swing.JMenuItem;

import Actions.QuitAction;
import frame.MazeApp;

public class QuitMenuItem extends JMenuItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Crée un bouton de menu "Quitter"
	 * @param app L'application en cours.
	 */
	public QuitMenuItem(MazeApp app) {
		super("Quitter");
		this.app = app;
		addActionListener(new QuitAction(app));
		
	}
}
