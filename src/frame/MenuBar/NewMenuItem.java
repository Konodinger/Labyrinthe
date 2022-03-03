package frame.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import frame.MazeApp;

public class NewMenuItem extends JMenuItem implements ActionListener {

	private final MazeApp app;
		
	public NewMenuItem(MazeApp app) {
		super("Nouveau");
		this.app = app;
		addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		
	}
}
