package frame.Buttons;

import javax.swing.JButton;

import frame.MazeApp;

public class ResolveButton extends JButton {
	
	private final MazeApp app;
	
	public ResolveButton(MazeApp app) {
		super("R�soudre");
		this.app = app;
	}
}
