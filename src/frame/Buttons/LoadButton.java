package frame.Buttons;

import javax.swing.JButton;

import frame.MazeApp;

public class LoadButton extends JButton {
	
	private final MazeApp app;
	
	public LoadButton(MazeApp app) {
		super("Charger");
		this.app = app;
	}

}
