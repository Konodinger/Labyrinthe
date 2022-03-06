package frame.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Actions.SaveAction;
import frame.MazeApp;

public class SaveButton extends JButton {
	
	private final MazeApp app;
	
	public SaveButton(MazeApp app) {
		super("Sauvegarder");
		this.app = app;
		addActionListener(new SaveAction(app));
		
	}

}
