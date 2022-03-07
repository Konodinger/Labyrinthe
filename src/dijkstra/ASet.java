package dijkstra;

import java.util.HashSet;

public class ASet extends HashSet<VertexInterface> implements ASetInterface {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Initialise l'ensemble de VertexInterface.
	 */
	public ASet() {
		super();
	}

	/**
	 * Ajoute un sommet � l'ensemble. 
	 */
	@Override
	public void setAdd(VertexInterface sommet) {
		// Ajoute l'�lement � l'ensemble s'il n'y est pas d�j�
		this.add(sommet);
	}

	/**
	 * Indique si un sommet se trouve dans l'ensemble.
	 */
	@Override
	public boolean isInSet(VertexInterface sommet) {
		// V�rifie si l'�l�ment appartient � l'ensemble
		return this.contains(sommet);
	}

}
