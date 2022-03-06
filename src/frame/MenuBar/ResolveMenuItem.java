package frame.MenuBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Actions.SaveAction;
import frame.MazeApp;

public class ResolveMenuItem extends JMenuItem implements ActionListener {

	private final MazeApp app;
	
	public ResolveMenuItem(MazeApp app) {
		super("Résoudre");
		this.app = app;
		addActionListener(new SaveAction(app));
		
	}

	public void actionPerformed(ActionEvent ev) {
		app.getMaze().resolve();
	}
}
