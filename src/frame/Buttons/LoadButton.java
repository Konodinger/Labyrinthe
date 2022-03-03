package frame.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import frame.MazeApp;

public class LoadButton extends JButton implements ActionListener {
	
	private final MazeApp app;
	
	public LoadButton(MazeApp app) {
		super("Charger");
		this.app = app;
		addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
