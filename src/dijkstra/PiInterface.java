package dijkstra;

import java.util.ArrayList;

public interface PiInterface {
	
	/**
	 * Associe une distance à un sommet.
	 * @param sommet Sommet de graphe.
	 * @param distance Distance associée au sommet.
	 */
	public void set(VertexInterface sommet, double distance);
	
	/**
	 * Donne la distance associée à un sommet.
	 * @param sommet Sommet de graphe.
	 * @return Distance associée au sommet.
	 */
	public double get(VertexInterface sommet);
	
	/**
	 * Donne le sommet aillant la distance la plus courte au sein d'une liste.
	 * @param A Liste de sommets de graphe.
	 * @return Sommet à la distance minimale.
	 */
	public VertexInterface minOfSet(ArrayList<VertexInterface> A);
}
