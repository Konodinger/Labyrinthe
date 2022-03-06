package frame.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Actions.NewAction;
import frame.MazeApp;

public class NewButton extends JButton {
	
	private final MazeApp app;
	
	public NewButton(MazeApp app) {
		super ("Nouveau");
		this.app = app;
		addActionListener(new NewAction(app));
		
	}

}
