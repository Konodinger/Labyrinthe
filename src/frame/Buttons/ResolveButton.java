package frame.Buttons;

import java.awt.event.*;

import javax.swing.JButton;

import frame.MazeApp;

public class ResolveButton extends JButton implements ActionListener {
	
	private final MazeApp app;
	
	public ResolveButton(MazeApp app) {
		super("Résoudre");
		this.app = app;
		addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent ev) {
		app.getMaze().resolve();
	}
	
}
