package maze;

public class WBox extends MBox{

	/**
	 * Boîte représentant un mur.
	 * @param x Coordonnée verticale.
	 * @param y Coordonnée horizontale.
	 */
	public WBox(int x, int y) {
		super(x, y);
	}

	/**
	 * Retourne le label de la boîte.
	 */
	@Override
	public String getLabel() {
		return "W";
	}
}
