package maze;

public class EBox extends MBox{

	/**
	 * Bo�te repr�sentant un espace vide.
	 * @param x Coordonn�e verticale.
	 * @param y Coordonn�e horizontale.
	 */
	public EBox(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Retourne le label de la bo�te.
	 */
	@Override
	public String getLabel() {
		return "E";
	}
}
