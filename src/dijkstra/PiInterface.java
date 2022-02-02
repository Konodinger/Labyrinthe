package dijkstra;

import java.util.ArrayList;

public interface PiInterface {
	public void set(VertexInterface sommet, double distance);
	public double get(VertexInterface sommet);
	public VertexInterface minOfSet(ArrayList<VertexInterface> A);
}
