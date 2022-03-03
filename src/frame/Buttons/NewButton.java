package frame.Buttons;

import javax.swing.JButton;

import frame.MazeApp;

public class NewButton extends JButton {
	
	private final MazeApp app;
	
	public NewButton(MazeApp app) {
		super ("Nouveau");
		this.app = app;
	}

}
