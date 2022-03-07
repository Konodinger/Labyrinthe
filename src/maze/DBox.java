package maze;

public class DBox extends EBox{

	/**
	 * Boîte représentant le départ.
	 * @param x Coordonnée verticale.
	 * @param y Coordonnée horizontale.
	 */
	public DBox(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Retourne le label de la boîte.
	 */
	@Override
	public String getLabel() {
		return "D";
	}
}
