package maze;

import dijkstra.VertexInterface;

public class MBox implements VertexInterface{
	private int x;
	private int y;
	private boolean highlight;
	
	/**
	 * Cr�ation d'une bo�te.
	 * @param x Coordonn�e verticale.
	 * @param y Coordonn�e horizontale.
	 */
	public MBox(int x, int y) {
		this.x = x;
		this.y = y;
		highlight = false;
	}

	/**
	 * Getter de la coordonn�e verticale.
	 * @return Coordonn�e verticale de la bo�te.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter de la coordonn�e horizontale.
	 * @return Coordonn�e horizontale de la bo�te.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Getter du surlignage.
	 * @return Surlignage de la bo�te.
	 */
	public boolean getHighlight() {
		return highlight;
	}
	
	/**
	 * Retourne le label de la bo�te.
	 */
	public String getLabel() {
		return "M";
	}

	/**
	 * Setter du surlignage.
	 * @param highlight Nouveau surlignage de la bo�te.
	 */
	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}
}
