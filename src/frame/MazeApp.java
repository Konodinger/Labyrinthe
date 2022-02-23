package frame;
import javax.swing.*;
import maze.*;

public class MazeApp extends JFrame {

	private final MazeMenuBar menuBar;
	
	public MazeApp(Maze laby) {
		super("Labyrinthe");
		setJMenuBar(menuBar = new MazeMenuBar(this));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
}
