package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import dijkstra.VertexInterface;
import maze.MBox;
import maze.Maze;

public class MazePanel extends JPanel {
	
	private final MazeApp app;
	private final Maze maze;
	private static ArrayList<MazeTile> tileList;
	
	public MazePanel(MazeApp app) {
		this.app = app;
		maze = app.getMaze();
		tileList = new ArrayList<MazeTile>();
		MazeTile nTile;
		setLayout(new GridLayout(maze.getHeight(), maze.getWidth()));
		for (VertexInterface box : maze.vertexList()) {
			nTile = new MazeTile(app, (MBox) box);
			add(nTile);
			tileList.add(nTile);
		}
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(500,500));
	}

	public void notifyForUpdate() {
		for (MazeTile tile : tileList) {
			tile.notifyForUpdate();
		}
	}

}
