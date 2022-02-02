package dijkstra;

public interface PreviousInterface {
	public void setPrevious(VertexInterface fils, VertexInterface pere);
	public VertexInterface getPrevious(VertexInterface fils);
}
