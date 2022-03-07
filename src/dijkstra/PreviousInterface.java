package dijkstra;

public interface PreviousInterface {
	
	/**
	 * Associe � un sommet fils le sommet p�re.
	 * @param fils Le sommet fils.
	 * @param pere Le sommet p�re associ�.
	 */
	public void setPrevious(VertexInterface fils, VertexInterface pere);
	
	/**
	 * Donne le sommet p�re associ� � un sommet fils.
	 * @param fils Le sommet � �tudier.
	 * @return Le p�re associ� au sommet fils.
	 */
	public VertexInterface getPrevious(VertexInterface fils);
}
