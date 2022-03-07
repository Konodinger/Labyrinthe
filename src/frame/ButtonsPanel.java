package frame;

import java.awt.GridLayout;

import javax.swing.JPanel;

import frame.Buttons.*;

public class ButtonsPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final NewButton newB;
	private final LoadButton load;
	private final SaveButton save;
	private final ResolveButton resolve;
	
	/**
	 * Initialise le panneau de boutons.
	 * @param app L'application en cours.
	 */
	public ButtonsPanel(MazeApp app) {
		setLayout(new GridLayout(1, 4));
		
		add(newB = new NewButton(app));
		add(load = new LoadButton(app));
		add(save = new SaveButton(app));
		add(resolve = new ResolveButton(app));
	}

}
