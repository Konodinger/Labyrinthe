package frame;
import javax.swing.*;

import frame.MenuBar.FileMenu;
import frame.MenuBar.QuitMenuItem;
import frame.MenuBar.ResolveMenuItem;

public class MazeMenuBar extends JMenuBar{
	
	private final FileMenu file;
	private final ResolveMenuItem resolve;
	private final QuitMenuItem quit;
	
	public MazeMenuBar (MazeApp app) {
		super();
		
		add(file = new FileMenu(app));
		add(resolve = new ResolveMenuItem(app));
		add(quit = new QuitMenuItem(app));
	}
}
