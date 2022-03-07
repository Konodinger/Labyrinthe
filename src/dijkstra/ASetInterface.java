package dijkstra;

public interface ASetInterface {
	
	/**
	 * Ajoute un sommet � l'ensemble.
	 * @param sommet Sommet � ajouter.
	 */
	public void setAdd(VertexInterface sommet);
	
	/**
	 * V�rifie si le sommet appartient � l'ensemble.
	 * @param sommet Le sommet � v�rifier.
	 * @return L'appartenance du sommet � l'ensemble.
	 */
	public boolean isInSet(VertexInterface sommet);
}