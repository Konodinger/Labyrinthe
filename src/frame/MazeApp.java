package frame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import maze.*;

public class MazeApp extends JFrame implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazeMenuBar menuBar;
	private final WindowPanel windowPanel;
	private Maze maze;
	private final MazeWindowListener mazeWindowListener;

	/**
	 * Getter du labyrinthe.
	 * @return Le labyrinthe associé à l'application.
	 */
	public Maze getMaze() {
		return maze;
	}
	
	/**
	 * Setter du labyrinthe.
	 * @param maze Le nouveau labyrinthe associé à l'application.
	 */
	public void setMaze(Maze maze) {
		this.maze = maze;
		maze.addObserver(this);
		stateChanged(new ChangeEvent(this));
		
	}
	
	/**
	 * Initialise l'application à partir du labyrinthe maze.
	 * @param maze Labyrinthe représenté dans l'application.
	 */
	public MazeApp(Maze maze) {
		super("Labyrinthe");
		this.maze = maze;
		setJMenuBar(menuBar = new MazeMenuBar(this));
		setContentPane(windowPanel = new WindowPanel(this));
		mazeWindowListener = new MazeWindowListener(this);
		addWindowListener(mazeWindowListener);
		maze.addObserver(this);

		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		pack();
		setVisible(true);
		
		JOptionPane.showInternalMessageDialog(windowPanel, "Bienvenue ! \n\n"
				+ "Commandes pour l'édition de texte :\n"
				+ " - Clic gauche pour poser/retirer un mur\n"
				+ " - Clic droit pour poser une case départ\n"
				+ " - Clic central (clic molette) pour poser une case arrivée", "Tutoriel", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Avertit la fenêtre d'un changement du labyrinthe.
	 */
	@Override
	public void stateChanged(ChangeEvent ev) {
		windowPanel.notifyForUpdate();
		
	}

}
