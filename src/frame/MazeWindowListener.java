package frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Actions.QuitAction;

public class MazeWindowListener extends WindowAdapter {
	
	private final MazeApp app;
	
	/**
	 * Initialise le WindowListener de l'application.
	 * @param app L'application en cours.
	 */
	public MazeWindowListener (MazeApp app) {
		super();
		this.app = app;
	}
	
	/**
	 * Lance l'action QuitAction lorsque la fenêtre de l'application est fermée.
	 */
	@Override
	public final void windowClosing(WindowEvent ev) {
		QuitAction quitAction = new QuitAction(app);
		quitAction.quit();
	}

}
