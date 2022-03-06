package Actions;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;

import frame.MazeApp;

public class pressAKey extends AbstractAction {
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		MazeApp.setKeyA(true);
	}

}
