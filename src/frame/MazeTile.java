package frame;

import java.awt.Color;

import javax.swing.JPanel;

import maze.MBox;
import maze.Maze;

public class MazeTile extends JPanel {
	
	private final MazeApp app;
	private final Maze maze;
	private static MBox box;
	
	public MazeTile(MazeApp app, Maze maze, MBox box) {
		this.app = app;
		this.maze = maze;
		this.box = box;
		setBackground();
	}
	
	private void setBackground() {
		if (box.getHighlight()) {
			setBackground(Color.CYAN);
		} else {
			switch(box.getLabel()) {
			case "E":
				setBackground(Color.GRAY);
				break;
			case "W":
				setBackground(Color.BLACK);
				break;
			case "D":
				setBackground(Color.GREEN);
				break;
			case "A":
				setBackground(Color.RED);
				break;
			default :
				setBackground(Color.WHITE);
			}
		}
	}

	public void notifyForUpdate() {
		setBackground();
		repaint();
		
	}

}
