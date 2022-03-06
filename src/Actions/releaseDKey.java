package Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import frame.MazeApp;

public class releaseDKey extends AbstractAction {
	
	public void actionPerformed(ActionEvent ev) {
		MazeApp.setKeyD(false);
	}

}