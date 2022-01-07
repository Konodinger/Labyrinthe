package tp04;

import java.util.ArrayList;

public interface GraphInterface {
	public ArrayList<VertexInterface> vertexList();
	public ArrayList<VertexInterface> successorVertex(VertexInterface sommet);
	public int length();
	public ArrayList<VertexInterface> notIn(ASetInterface A);
	public double p(VertexInterface x, VertexInterface y);
}
