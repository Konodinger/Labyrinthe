package maze;

import dijkstra.VertexInterface;

public class MBox implements VertexInterface{
	private int x;
	private int y;
	
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
	public String getLabel() {
		return "M";
	}
}
