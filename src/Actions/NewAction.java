package Actions;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import frame.MazeApp;
import maze.EBox;
import maze.MBox;
import maze.Maze;

public class NewAction extends AbstractAction{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
 	* Initialise LoadAction.
 	* @param app L'application en cours.
 	*/
	public NewAction(MazeApp app) {
		super();
		this.app = app;
	}
	
	/**
	 * Demande à l'utilisateur de rentrer un entier strictement positif représentant (à priori) un nombre de colonne ou de ligne.
	 * @param message La nature de l'entier à entrer.
	 * @return L'entier entré, ou bien 0 si la requête a échoué.
	 */
	public int inputInt(String message) {
		int val = 0;
		while (true) {
			try {
				String input = JOptionPane.showInputDialog(app, "Entrez " + message + " :", "10");
				if (input != null) {
					val = Integer.parseInt(input);
					if (val <= 0) {
						throw new NumberFormatException();
					}
				}
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(app, "Erreur : veuillez entrer un entier strictement positif.", "alert", JOptionPane.ERROR_MESSAGE);
			}
		}
		return val;
	}

	/**
	 * Crée un nouveau labyrinthe lorsqu'un clic gauche est effectué.
	 */
	public void actionPerformed(ActionEvent ev) {
		if (ev.getModifiers() == 16) {
			ArrayList<ArrayList<MBox>> laby = new ArrayList<ArrayList<MBox>>();
			int colonne;
			int ligne;
			if ((colonne = inputInt("le nombre de colonnes du nouveau labyrinthe")) != 0) {
				if ((ligne = inputInt("le nombre de lignes du nouveau labyrinthe")) != 0) {
					ArrayList<MBox> etage;
					
					for (int x = 0; x < colonne; x++) {
						etage = new ArrayList<MBox>();
						for (int y = 0; y < ligne; y++) {
							etage.add(new EBox(x,y));
						}
						laby.add(etage);
					}
					
					try {
						app.setMaze(new Maze(laby));
					} catch (Exception e) {
						System.out.println("Erreur dans la création du nouveau labyrinthe.");
					}
				}
			}
		}
	}

}
