package maze;

public class WBox extends MBox{

	/**
	 * Bo�te repr�sentant un mur.
	 * @param x Coordonn�e verticale.
	 * @param y Coordonn�e horizontale.
	 */
	public WBox(int x, int y) {
		super(x, y);
	}

	/**
	 * Retourne le label de la bo�te.
	 */
	@Override
	public String getLabel() {
		return "W";
	}
}
