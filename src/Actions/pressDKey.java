package Actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import frame.MazeApp;

public class pressDKey extends AbstractAction {
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		MazeApp.setKeyD(true);
	}

}