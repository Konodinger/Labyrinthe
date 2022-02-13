package maze;

import dijkstra.VertexInterface;

public class MBox implements VertexInterface{
	private int x;
	private int y;
	private boolean highlight = false;
	
	public MBox(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getHighlight() {
		return highlight;
	}
	
	public String getLabel() {
		return "M";
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}
}
