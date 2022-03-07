package Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import frame.MazeApp;

public class ResolveAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Initialise ResolveAction.
	 * @param app L'application en cours.
	 */
	public ResolveAction(MazeApp app) {
		super();
		this.app = app;
	}
	
	/**
	 * Tente de r�soudre le labyrinthe lorsqu'un clic gauche est effectu�.
	 */
	public void actionPerformed(ActionEvent ev) {
		if (ev.getModifiers() == 16) {
			if (!app.getMaze().resolve()) {
				JOptionPane.showMessageDialog(app, "Le labyrinthe n'est pas r�solvable.", "alert", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
