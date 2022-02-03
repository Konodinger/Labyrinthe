package dijkstra;

import java.util.HashSet;

public class ASet extends HashSet<VertexInterface> implements ASetInterface {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ASet() {
		super();
	}

	@Override
	public void setAdd(VertexInterface sommet) {
		// Ajoute l'élement à l'ensemble s'il n'y est pas déjà
		this.add(sommet);
	}

	@Override
	public boolean isInSet(VertexInterface sommet) {
		// Vérifie si l'élément appartient à l'ensemble
		return this.contains(sommet);
	}

}
