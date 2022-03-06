package Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import frame.MazeApp;

public class SaveAction extends AbstractAction{

	private final MazeApp app;
	
	public SaveAction(MazeApp app) {
		super();
		this.app = app;
	}
	
	public boolean save() {
		boolean notSaved = true;
		while (notSaved) {
			String file = JOptionPane.showInputDialog(app, "Entrez le nom du fichier o� enregistrer votre labyrinthe :", "labyrinthe");
			if ((file == null)) {
				break;
			} else {
				try {
					if (file.isBlank()) {
						JOptionPane.showMessageDialog(app, "Erreur : le nom du fichier est vide ou bien n'est compos� que d'espaces.", "alert", JOptionPane.ERROR_MESSAGE);
					} else {
						app.getMaze().saveToTextFile(file);
						notSaved = false;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(app, "Erreur : impossible de sauvegarder le labyrinthe.", "alert", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		return !notSaved;
	}
	
	public void actionPerformed(ActionEvent ev) {
		if (ev.getModifiers() == 16) {
			save();
		}
	}

}