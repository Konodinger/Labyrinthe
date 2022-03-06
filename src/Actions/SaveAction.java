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
	
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Hey");
		boolean notSaved = true;
		while (notSaved) {
			String file = JOptionPane.showInputDialog(app, "Entrez le nom du fichier où enregistrer votre labyrinthe :", "labyrinthe");
			System.out.println(file);
			if ((file == null)) {
				notSaved = false;
			} else {
				try {
					if (file.isBlank()) {
						JOptionPane.showMessageDialog(app, "Erreur : le nom du fichier est vide ou bien n'est composé que d'espaces.", "alert", JOptionPane.ERROR_MESSAGE);
					} else {
						app.getMaze().saveToTextFile(file);
						notSaved = false;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(app, "Erreur : impossible de sauvegarder le labyrinthe.", "alert", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

}
