package tp04;

import java.util.ArrayList;

import maze.MBox;
import maze.Maze;

public class MainTest {

	public static void main(String[] args) {
		final Maze maze = new Maze(new ArrayList<ArrayList<MBox>>());
		try {
			maze.initFromTextFile("data/labyrinthe.txt");
		} catch (Exception e) {
			System.out.println("Erreur durant la création du labyrinthe");
			System.out.println(e);
		}
		try {
			maze.saveToTextFile("data/labyrinthe2.txt");
		} catch (Exception e) {
			System.out.println("Erreur durant la sauvegarde du labyrinthe");
			System.out.println(e);
		}
	}

}
