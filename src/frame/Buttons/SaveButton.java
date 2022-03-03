package frame.Buttons;

import javax.swing.JButton;

import frame.MazeApp;

public class SaveButton extends JButton {
	
	private final MazeApp app;
	
	public SaveButton(MazeApp app) {
		super("Sauvegarder");
		this.app = app;
	}

}
