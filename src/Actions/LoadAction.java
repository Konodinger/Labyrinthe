package Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import frame.MazeApp;

public class LoadAction extends AbstractAction{

	private final MazeApp app;
	
	public LoadAction(MazeApp app) {
		super();
		this.app = app;
	}
	
	public boolean load() {
		boolean notLoaded = true;
		while (notLoaded) {
			String file = JOptionPane.showInputDialog(app, "Entrez le nom du fichier à charger :", "labyrinthe");
			if ((file == null)) {
				break;
			} else {
				try {
					if (file.isBlank()) {
						JOptionPane.showMessageDialog(app, "Erreur : le nom du fichier est vide ou bien n'est composé que d'espaces.", "alert", JOptionPane.ERROR_MESSAGE);
					} else {
						app.getMaze().initFromTextFile(file);
						notLoaded = false;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(app, "Erreur : impossible de charger le labyrinthe.", "alert", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		return !notLoaded;
	}
	
	public void actionPerformed(ActionEvent ev) {
		if (ev.getModifiers() == 16) {
			load();
		}
	}
}
