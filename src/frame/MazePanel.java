package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import dijkstra.VertexInterface;
import maze.MBox;
import maze.Maze;

public class MazePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeApp app;
	
	/**
	 * Initialise le tableau représentant le labyrinthe.
	 * @param app L'application en cours.
	 */
	public MazePanel(MazeApp app) {
		super();
		this.app = app;
		printMaze(app.getMaze());
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(700,700));
	}
	
	/**
	 * Crée des cases correspondantes aux boîtes du labyrinthe.
	 * @param maze
	 */
	public void printMaze(Maze maze) {
		MazeTile nTile;
		setLayout(new GridLayout(maze.getHeight(), maze.getWidth()));
		for (VertexInterface box : maze.vertexList()) {
			nTile = new MazeTile(app, (MBox) box);
			add(nTile);
		}
	}

	/**
	 * Met à jour ses cases en cas de changement du labyrinthe.
	 */
	public void notifyForUpdate() {
		removeAll();
		printMaze(app.getMaze());
	}

}
