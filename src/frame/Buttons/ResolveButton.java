package frame.Buttons;

import javax.swing.JButton;

import frame.MazeApp;

public class ResolveButton extends JButton {
	
	private final MazeApp app;
	
	public ResolveButton(MazeApp app) {
		super("Résoudre");
		this.app = app;
	}
}
