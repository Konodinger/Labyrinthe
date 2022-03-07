package frame.Buttons;

import javax.swing.JButton;

import Actions.ResolveAction;
import frame.MazeApp;

public class ResolveButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Cr�e un bouton "R�soudre".
	 * @param app L'application en cours.
	 */
	public ResolveButton(MazeApp app) {
		super("R�soudre");
		this.app = app;
		addActionListener(new ResolveAction(app));
		
	}
	
}
