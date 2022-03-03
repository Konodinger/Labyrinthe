package frame;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import maze.*;

public class MazeApp extends JFrame implements ChangeListener {

	private final MazeMenuBar menuBar;
	private final WindowPanel windowPanel;
	private final TileKeyBoardListener tileKeyBoardListener;
	
	private static Maze maze;

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		MazeApp.maze = maze;
	}
	
	public MazeApp(Maze maze) {
		super("Labyrinthe");
		setMaze(maze);
		setJMenuBar(menuBar = new MazeMenuBar(this));
		setContentPane(windowPanel = new WindowPanel(this));
		maze.addObserver(this);
		tileKeyBoardListener = new TileKeyBoardListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent ev) {
		windowPanel.notifyForUpdate();
		
	}
	
}
