package maze;

public class ABox extends EBox{

	/**
	 * Boîte représentant l'arrivée.
	 * @param x Coordonnée verticale.
	 * @param y Coordonnée horizontale.
	 */
	public ABox(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Retourne le label de la boîte.
	 */
	@Override
	public String getLabel() {
		return "A";
	}
}
