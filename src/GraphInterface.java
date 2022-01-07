public interface GraphInterface {
	public VertexInterface[] vertexList();
	public VertexInterface[] successorVertex(VertexInterface sommet);
	public int length();
	public VertexInterface[] notIn(ASetInterface A);
	public double p(VertexInterface x, VertexInterface y);
}
