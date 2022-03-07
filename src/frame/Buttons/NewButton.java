package frame.Buttons;

import javax.swing.JButton;

import Actions.NewAction;
import frame.MazeApp;

public class NewButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Crée un bouton "Nouveau".
	 * @param app L'application en cours.
	 */
	public NewButton(MazeApp app) {
		super ("Nouveau");
		this.app = app;
		addActionListener(new NewAction(app));
		
	}

}
