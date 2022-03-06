package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import dijkstra.VertexInterface;
import maze.MBox;
import maze.Maze;

public class MazePanel extends JPanel {
	
	private final MazeApp app;
	private ArrayList<MazeTile> liste;
	
	public MazePanel(MazeApp app) {
		super();
		this.app = app;
		printMaze(app.getMaze());
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(500,500));
	}
	
	public void printMaze(Maze maze) {
		MazeTile nTile;
		liste = new ArrayList<MazeTile>();
		setLayout(new GridLayout(maze.getHeight(), maze.getWidth()));
		for (VertexInterface box : maze.vertexList()) {
			nTile = new MazeTile(app, (MBox) box);
			add(nTile);
			liste.add(nTile);
		}
	}

	public void notifyForUpdate() {
		removeAll();
		printMaze(app.getMaze());
		revalidate();
	}

}
