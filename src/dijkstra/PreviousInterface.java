package dijkstra;

public interface PreviousInterface {
	
	/**
	 * Associe à un sommet fils le sommet père.
	 * @param fils Le sommet fils.
	 * @param pere Le sommet père associé.
	 */
	public void setPrevious(VertexInterface fils, VertexInterface pere);
	
	/**
	 * Donne le sommet père associé à un sommet fils.
	 * @param fils Le sommet à étudier.
	 * @return Le père associé au sommet fils.
	 */
	public VertexInterface getPrevious(VertexInterface fils);
}
