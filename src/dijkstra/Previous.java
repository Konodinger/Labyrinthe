package dijkstra;

import java.util.Hashtable;

public class Previous extends Hashtable<VertexInterface, VertexInterface> implements PreviousInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Initialise la fontion de hachage.
	 */
	public Previous() {
		super();
	}
	
	/**
	 * Associe � un sommet fils le sommet p�re.
	 */
	@Override
	public void setPrevious(VertexInterface fils, VertexInterface pere) {
		put(fils, pere);
	}

	/**
	 * Donne le sommet p�re associ� � un sommet fils, ou null si celui-ci n'en a pas encore eu d'associ�.
	 */
	@Override
	public VertexInterface getPrevious(VertexInterface fils) {
		return get(fils);
	}
}
