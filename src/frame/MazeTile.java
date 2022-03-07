package frame;

import java.awt.Color;

import javax.swing.JPanel;

import maze.MBox;

public class MazeTile extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MBox box;
	private final int x;
	private final int y;
	private final TileMouseListener tileMouseListener;
	
	/**
	 * Initialise une case représentant une boîte du labyrinthe.
	 * @param app L'application en cours.
	 * @param box La boîte représentée par cette case.
	 */
	public MazeTile(MazeApp app, MBox box) {
		super();
		this.box = box;
		x = box.getX();
		y = box.getY();
		setBackground();
		
		tileMouseListener = new TileMouseListener(app, x, y);
		addMouseListener(tileMouseListener);
	}
	
	/**
	 * Donne la couleur de fond de la case en fonction de la boîte représentée.
	 */
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

}
