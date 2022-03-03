package frame.MenuBar;

import javax.swing.JMenu;

import frame.MazeApp;

public class FileMenu extends JMenu {
	
	private final NewMenuItem newItem;
	private final LoadMenuItem load;
	private final SaveMenuItem save;
	
	public FileMenu (MazeApp app) {
		super("Fichier");
		
		add(newItem = new NewMenuItem(app));
		add(load = new LoadMenuItem(app));
		add(save = new SaveMenuItem(app));
	}

}
