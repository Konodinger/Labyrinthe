package frame.MenuBar;

import javax.swing.JMenuItem;
import frame.MazeApp;

public class NewMenuItem extends JMenuItem {

	private final MazeApp app;
		
	public NewMenuItem(MazeApp app) {
		super("Nouveau");
		this.app = app;
		
	}
}
