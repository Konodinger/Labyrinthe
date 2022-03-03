package frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TileMouseListener extends MouseAdapter {
	
	private final MazeTile tile;
	
	public TileMouseListener(MazeTile tile) {
		super();
		this.tile = tile;
		
	}
	
	@Override
	public final void mousePressed(MouseEvent e) {
		tile.replace();
	}
}
