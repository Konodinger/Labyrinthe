package frame.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Actions.LoadAction;
import Actions.NewAction;
import frame.MazeApp;

public class LoadButton extends JButton {
	
	private final MazeApp app;
	
	public LoadButton(MazeApp app) {
		super("Charger");
		this.app = app;
		addActionListener(new LoadAction(app));
		
	}

}
