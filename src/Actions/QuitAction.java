package Actions;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import frame.MazeApp;

public class QuitAction extends AbstractAction{
	
private final MazeApp app;
	
	public QuitAction(MazeApp app) {
		super();
		this.app = app;
	}
	
	public void quit() {
		if (!app.getMaze().isSaved()) {
			int input = JOptionPane.showInternalOptionDialog(null, "Voulez-vous sauvegarder le labyrinthe ?", "Fermeture", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
			if ((input == JOptionPane.CANCEL_OPTION) || input == JOptionPane.CLOSED_OPTION) {
				return;
			} else if (input == JOptionPane.OK_OPTION) {
				SaveAction saveAction = new SaveAction(app);
				if (!saveAction.save()) {
					return;
				}
			}
		}
		System.exit(0);
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getModifiers() == 16) {
			quit();
		}
	}

}
