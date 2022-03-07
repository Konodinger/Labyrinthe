package main;

import java.util.ArrayList;

import frame.MazeApp;
import maze.MBox;
import maze.Maze;

public class MainTest {
	
	private static String file = "labyrinthe";
	private static Maze maze;
	
	/**
	 * Lance l'application labyrinthe, en lisant par défaut le fichier data/labyrinthe.txt.
	 * @param args Non pris en compte.
	 */
	public static void main(String[] args) {
		
		//Manipulation du labyrinthe
		try {
			
			//Chargement du labyinthe à  partir d'un fichier
			maze = new Maze(new ArrayList<ArrayList<MBox>>());
			maze.initFromTextFile(file);
			
			//Création de l'IHM
			new MazeApp(maze);
			
		} catch (Exception e) {
			System.out.println("Erreur durant la manipulation du labyrinthe");
			System.out.println(e);
		}
	}

}
