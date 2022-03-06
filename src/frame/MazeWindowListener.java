package frame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Actions.QuitAction;

public class MazeWindowListener extends WindowAdapter {
	
	private final MazeApp app;
	
	public MazeWindowListener (MazeApp app) {
		super();
		this.app = app;
	}
	
	@Override
	public final void windowClosing(WindowEvent ev) {
		QuitAction quitAction = new QuitAction(app);
		quitAction.quit();
	}

}
