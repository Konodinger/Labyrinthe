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
		// Inscrit dans la table de hachage que le sommet fils a pour prédécesseur le sommet père
		put(fils, pere);
	}

	@Override
	public VertexInterface getPrevious(VertexInterface fils) {
		// Indique le prédécesseur du sommet indiqué, ou null si celui-ci n'en a pas encore eu de désigné.
		return get(fils);
	}
}
