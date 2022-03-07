package frame.MenuBar;

import javax.swing.JMenu;

import frame.MazeApp;

public class FileMenu extends JMenu {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final NewMenuItem newItem;
	private final LoadMenuItem load;
	private final SaveMenuItem save;
	
	/**
	 * Crée un menu "Fichier"
	 * @param app L'application en cours.
	 */
	public FileMenu (MazeApp app) {
		super("Fichier");
		
		add(newItem = new NewMenuItem(app));
		add(load = new LoadMenuItem(app));
		add(save = new SaveMenuItem(app));
	}

}
