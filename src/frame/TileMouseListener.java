package frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import maze.Maze;

public class TileMouseListener extends MouseAdapter {
	
	private final MazeApp app;
	private final int x;
	private final int y;
	
	public TileMouseListener(MazeApp app, int x, int y) {
		super();
		this.app = app;
		this.x = x;
		this.y = y;
		
	}
	
	@Override
	public void mousePressed(MouseEvent ev) {
		app.getMaze().setSaved(false);
		if (app.getMaze().getHighlighted()) {
			app.getMaze().eraseHighlight();
		}
		switch(ev.getButton()) {
		case MouseEvent.BUTTON1 :
			app.getMaze().changeBoxEW(x, y);
			break;
		case MouseEvent.BUTTON2 :
			app.getMaze().changeBoxD(x, y);
			break;
		case MouseEvent.BUTTON3 :
			app.getMaze().changeBoxA(x, y);
			break;
			
		}
	}
	
}
