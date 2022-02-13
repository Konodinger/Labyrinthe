package dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

public class Pi extends Hashtable<VertexInterface, Double> implements PiInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Pi() {
		super();
	}
	
	@Override
	public void set(VertexInterface sommet, double distance) {
		// Inscrit la distance associée à ce sommet.
		put(sommet, distance);
	}
	
	@Override
	public double get(VertexInterface sommet) {
		// Retourne la distance inscrite pour ce sommet, ou null si celui-ci n'en a pas encore d'associée.
		return super.get(sommet);
	}

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
