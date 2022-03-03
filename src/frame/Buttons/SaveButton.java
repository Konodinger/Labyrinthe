package frame.Buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import frame.MazeApp;

public class SaveButton extends JButton implements ActionListener {
	
	private final MazeApp app;
	
	public SaveButton(MazeApp app) {
		super("Sauvegarder");
		this.app = app;
		addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		Object saveFile = JOptionPane.showInternalInputDialog(null, "Choisissez un emplacement de sauvegarde.");
	}

}
