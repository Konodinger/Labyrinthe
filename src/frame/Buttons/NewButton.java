package frame.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import frame.MazeApp;

public class NewButton extends JButton implements ActionListener {
	
	private final MazeApp app;
	
	public NewButton(MazeApp app) {
		super ("Nouveau");
		this.app = app;
		addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}

}
