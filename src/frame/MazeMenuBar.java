package frame;
import javax.swing.*;

import frame.MenuBar.FileMenu;
import frame.MenuBar.QuitMenuItem;
import frame.MenuBar.ResolveMenuItem;

public class MazeMenuBar extends JMenuBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final FileMenu file;
	private final ResolveMenuItem resolve;
	private final QuitMenuItem quit;
	
	/**
	 * Initialise la barre de menu.
	 * @param app L'application en cours.
	 */
	public MazeMenuBar (MazeApp app) {
		super();
		
		add(file = new FileMenu(app));
		add(resolve = new ResolveMenuItem(app));
		add(quit = new QuitMenuItem(app));
	}
}
