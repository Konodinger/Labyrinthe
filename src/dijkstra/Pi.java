package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

public class Pi extends Hashtable<VertexInterface, Double> implements PiInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Initialise la table de hachage.
	 */
	public Pi() {
		super();
	}
	
	/**
	 * Associe une distance à un sommet.
	 */
	@Override
	public void set(VertexInterface sommet, double distance) {
		put(sommet, distance);
	}
	
	/**
	 * Donne la distance associée à ce sommet, ou null si celui-ci n'en a pas encore d'associée.
	 */
	@Override
	public double get(VertexInterface sommet) {
		return super.get(sommet);
	}

	/**
	 * Donne le sommet aillant la distance la plus courte au sein d'une liste.
	 */
	public VertexInterface minOfSet(ArrayList<VertexInterface> A) {
		int taille = A.size();
		VertexInterface sommet = null;
		double distance = Double.POSITIVE_INFINITY;
		for (int i = 0; i < taille; i++) {
			if (get(A.get(i)) < distance) {
				sommet = A.get(i);
				distance = get(A.get(i));
			}
		}
		return sommet;
	}

}
