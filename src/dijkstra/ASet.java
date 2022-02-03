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
		// Ajoute l'�lement � l'ensemble s'il n'y est pas d�j�
		this.add(sommet);
	}

	@Override
	public boolean isInSet(VertexInterface sommet) {
		// V�rifie si l'�l�ment appartient � l'ensemble
		return this.contains(sommet);
	}

}
