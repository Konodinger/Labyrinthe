package frame;

import java.awt.Color;

import javax.swing.JPanel;

import maze.MBox;
import maze.Maze;

public class MazeTile extends JPanel {
	
	private final MazeApp app;
	private MBox box;
	private final TileMouseListener tileMouseListener;
	
	public MazeTile(MazeApp app, MBox box) {
		this.app = app;
		this.box = box;
		setBackground();
		tileMouseListener = new TileMouseListener(this);
		
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

	public void notifyForUpdate() {
		setBackground();
		repaint();
		
	}

	public void replace() {
		box = app.getMaze().changeBox(box.getX(), box.getY());
		notifyForUpdate();
	}

}
