package tp04;

import java.util.ArrayList;

public class MainTest {

	public static void main(String[] args) {
		final Maze maze = new Maze(new ArrayList<ArrayList<MBox>>());
		maze.initFromTextFile("data/labyrinthe.txt");
		maze.saveToTextFile("data/labyrinthe2.txt");
	}

}
