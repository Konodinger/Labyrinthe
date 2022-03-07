package frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Actions.QuitAction;
import Actions.SaveAction;
import maze.*;

public class MazeApp extends JFrame implements ChangeListener {

	private final MazeMenuBar menuBar;
	private final WindowPanel windowPanel;
	private Maze maze;
	private final MazeWindowListener mazeWindowListener;
	
	private static boolean keyA;
	private static boolean keyD;

	public Maze getMaze() {
		return maze;
	}
	
	public void setMaze(Maze maze) {
		this.maze = maze;
		maze.addObserver(this);
		stateChanged(new ChangeEvent(this));
		
	}

	public void setInputMode(char inputMode) {
		System.out.println(inputMode);
		
	}

	public static boolean isKeyA() {
		return keyA;
	}

	public static void setKeyA(boolean keyA) {
		MazeApp.keyA = keyA;
	}

	public static boolean isKeyD() {
		return keyD;
	}

	public static void setKeyD(boolean keyD) {
		MazeApp.keyD = keyD;
	}
	
	public MazeApp(Maze maze) {
		super("Labyrinthe");
		this.maze = maze;
		setKeyA(false);
		setKeyD(false);
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

	@Override
	public void stateChanged(ChangeEvent ev) {
		windowPanel.notifyForUpdate();
		
	}

}
