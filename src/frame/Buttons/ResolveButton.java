package frame.Buttons;

import java.awt.event.*;

import javax.swing.JButton;

import Actions.ResolveAction;
import frame.MazeApp;

public class ResolveButton extends JButton {
	
	private final MazeApp app;
	
	public ResolveButton(MazeApp app) {
		super("Résoudre");
		this.app = app;
		addActionListener(new ResolveAction(app));
		
	}
	
}
