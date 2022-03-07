package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class WindowPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final MazePanel mazePanel;
	private final ButtonsPanel buttonsPanel;
	
	/**
	 * Initialise la fenêtre de l'application.
	 * @param app L'application en cours.
	 */
	public WindowPanel(MazeApp app) {
		
		add(mazePanel = new MazePanel(app), BorderLayout.NORTH);
		add(buttonsPanel = new ButtonsPanel(app), BorderLayout.SOUTH);
		
		setPreferredSize(new Dimension(700,750));
	}

	/**
	 * Avertit le tableau de case d'un changement du labyrinthe.
	 */
	public void notifyForUpdate() {
		mazePanel.notifyForUpdate();
		revalidate();
	}

}
