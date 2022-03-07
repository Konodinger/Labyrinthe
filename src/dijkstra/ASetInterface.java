package dijkstra;

public interface ASetInterface {
	
	/**
	 * Ajoute un sommet à l'ensemble.
	 * @param sommet Sommet à ajouter.
	 */
	public void setAdd(VertexInterface sommet);
	
	/**
	 * Vérifie si le sommet appartient à l'ensemble.
	 * @param sommet Le sommet à vérifier.
	 * @return L'appartenance du sommet à l'ensemble.
	 */
	public boolean isInSet(VertexInterface sommet);
}