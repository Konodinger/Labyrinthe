package frame.Buttons;

import javax.swing.JButton;

import Actions.LoadAction;
import frame.MazeApp;

public class LoadButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Crée un bouton "Charger".
	 * @param app L'application en cours.
	 */
	public LoadButton(MazeApp app) {
		super("Charger");
		this.app = app;
		addActionListener(new LoadAction(app));
		
	}

}
