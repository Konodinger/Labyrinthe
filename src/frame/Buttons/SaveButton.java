package frame.Buttons;

import javax.swing.JButton;

import Actions.SaveAction;
import frame.MazeApp;

public class SaveButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Crée un bouton "Sauvegarder".
	 * @param app L'application en cours.
	 */
	public SaveButton(MazeApp app) {
		super("Sauvegarder");
		this.app = app;
		addActionListener(new SaveAction(app));
		
	}

}
