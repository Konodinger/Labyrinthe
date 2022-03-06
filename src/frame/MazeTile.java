package frame;

import java.awt.Color;

import javax.swing.JPanel;

import maze.MBox;
import maze.Maze;

public class MazeTile extends JPanel {
	
	private final MazeApp app;
	private MBox box;
	private final int x;
	private final int y;
	private final TileMouseListener tileMouseListener;
	
	public MazeTile(MazeApp app, MBox box) {
		super();
		this.app = app;
		this.box = box;
		x = box.getX();
		y = box.getY();
		setBackground();
		
		tileMouseListener = new TileMouseListener(app, x, y);
		addMouseListener(tileMouseListener);
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
	
	public MBox getBox() {
		return box;
	}

}
