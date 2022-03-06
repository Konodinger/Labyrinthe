package frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	public final void mousePressed(MouseEvent ev) {
		
		app.getMaze().setSaved(false);
		if (app.getMaze().getHighlighted()) {
			app.getMaze().eraseHighlight();
		}
		
		if (MazeApp.isKeyA()) {
			app.getMaze().changeBoxA(x, y);
		} else if (MazeApp.isKeyD()) {
			app.getMaze().changeBoxD(x, y);
		} else {
			app.getMaze().changeBoxEW(x, y);
		}
	}
}
