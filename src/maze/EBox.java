package maze;

public class EBox extends MBox{

	/**
	 * Boîte représentant un espace vide.
	 * @param x Coordonnée verticale.
	 * @param y Coordonnée horizontale.
	 */
	public EBox(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Retourne le label de la boîte.
	 */
	@Override
	public String getLabel() {
		return "E";
	}
}
