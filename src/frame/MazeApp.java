package frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import maze.*;

public class MazeApp extends JFrame implements ChangeListener {

	private final MazeMenuBar menuBar;
	private final WindowPanel windowPanel;
	
	private static Maze maze;
	private static boolean keyA;
	private static boolean keyD;

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		MazeApp.maze = maze;
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
		maze.addObserver(this);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	@Override
	public void stateChanged(ChangeEvent ev) {
		windowPanel.notifyForUpdate();
		
	}
	
}
