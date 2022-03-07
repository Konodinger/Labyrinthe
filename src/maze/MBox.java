package maze;

import dijkstra.VertexInterface;

public class MBox implements VertexInterface{
	private int x;
	private int y;
	private boolean highlight;
	
	/**
	 * Création d'une boîte.
	 * @param x Coordonnée verticale.
	 * @param y Coordonnée horizontale.
	 */
	public MBox(int x, int y) {
		this.x = x;
		this.y = y;
		highlight = false;
	}

	/**
	 * Getter de la coordonnée verticale.
	 * @return Coordonnée verticale de la boîte.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter de la coordonnée horizontale.
	 * @return Coordonnée horizontale de la boîte.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Getter du surlignage.
	 * @return Surlignage de la boîte.
	 */
	public boolean getHighlight() {
		return highlight;
	}
	
	/**
	 * Retourne le label de la boîte.
	 */
	public String getLabel() {
		return "M";
	}

	/**
	 * Setter du surlignage.
	 * @param highlight Nouveau surlignage de la boîte.
	 */
	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}
}
