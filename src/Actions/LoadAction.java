package Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import frame.MazeApp;

public class LoadAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Initialise LoadAction.
	 * @param app L'application en cours.
	 */
	public LoadAction(MazeApp app) {
		super();
		this.app = app;
	}
	
	/**
	 * Charge un labyrinthe depuis un fichier dont on demande le nom.
	 * @return La réussite du chargement.
	 */
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
	
	/**
	 * Lance load() lorsqu'un clic gauche est effectué.
	 */
	public void actionPerformed(ActionEvent ev) {
		if (ev.getModifiers() == 16) {
			load();
		}
	}
}
