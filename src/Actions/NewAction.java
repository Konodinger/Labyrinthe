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
	
private final MazeApp app;
	
	public NewAction(MazeApp app) {
		super();
		this.app = app;
	}
	
	public int inputInt() {
		int val = 0;
		while (true) {
			try {
				String input = JOptionPane.showInputDialog(app, "Entrez le nombre de colonnes du nouveau labyrinthe :", "10");
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

	public void actionPerformed(ActionEvent ev) {
		System.out.println("Hey");
		ArrayList<ArrayList<MBox>> laby = new ArrayList<ArrayList<MBox>>();
		int colonne;
		int ligne;
		if ((colonne = inputInt()) != 0) {
			if ((ligne = inputInt()) != 0) {
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
