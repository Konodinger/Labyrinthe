package dijkstra;

import java.util.Hashtable;

public class Previous extends Hashtable<VertexInterface, VertexInterface> implements PreviousInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Previous() {
		super();
	}
	
	@Override
	public void setPrevious(VertexInterface fils, VertexInterface pere) {
		// Inscrit dans la table de hachage que le sommet fils a pour pr�d�cesseur le sommet p�re
		put(fils, pere);
	}

	@Override
	public VertexInterface getPrevious(VertexInterface fils) {
		// Indique le pr�d�cesseur du sommet indiqu�, ou null si celui-ci n'en a pas encore eu de d�sign�.
		return get(fils);
	}
}
