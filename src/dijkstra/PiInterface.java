package dijkstra;

import java.util.ArrayList;

public interface PiInterface {
	
	/**
	 * Associe une distance � un sommet.
	 * @param sommet Sommet de graphe.
	 * @param distance Distance associ�e au sommet.
	 */
	public void set(VertexInterface sommet, double distance);
	
	/**
	 * Donne la distance associ�e � un sommet.
	 * @param sommet Sommet de graphe.
	 * @return Distance associ�e au sommet.
	 */
	public double get(VertexInterface sommet);
	
	/**
	 * Donne le sommet aillant la distance la plus courte au sein d'une liste.
	 * @param A Liste de sommets de graphe.
	 * @return Sommet � la distance minimale.
	 */
	public VertexInterface minOfSet(ArrayList<VertexInterface> A);
}
