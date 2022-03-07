package dijkstra;

import java.util.ArrayList;

public interface GraphInterface {
	
	/**
	 * Donne la liste de tous les sommets du graphe.
	 * @return La liste de tous les sommets.
	 */
	public ArrayList<VertexInterface> vertexList();
	
	/**
	 * Donne la liste des succésseurs d'un sommet du graphe.
	 * @param sommet Le sommet de départ.
	 * @return La liste des succésseurs de sommet.
	 */
	public ArrayList<VertexInterface> successorVertex(VertexInterface sommet);
	
	/**
	 * Donne la taille du graphe.
	 * @return La taille du graphe.
	 */
	public int length();
	
	/**
	 * Donne la liste des sommets du graphe qui ne sont pas dans l'ensemble A.
	 * @param A Un ensemble de sommets du graphe.
	 * @return La liste des sommets qui ne sont pas dans A.
	 */
	public ArrayList<VertexInterface> notIn(ASetInterface A);
	
	/**
	 * Donne le poids du trajet depuis le sommet x vers le sommet y.
	 * @param x Le sommet de départ.
	 * @param y Le sommet d'arrivée.
	 * @return Le poids du trajet. +infini si le trajet n'est pas possible.
	 */
	public double p(VertexInterface x, VertexInterface y);
}
