package Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import frame.MazeApp;

public class ResolveAction extends AbstractAction{

	private final MazeApp app;
	
	public ResolveAction(MazeApp app) {
		super();
		this.app = app;
	}
	
	public void actionPerformed(ActionEvent ev) {
		if (ev.getModifiers() == 16) {
			if (!app.getMaze().resolve()) {
				JOptionPane.showMessageDialog(app, "Le labyrinthe n'est pas résolvable.", "alert", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
