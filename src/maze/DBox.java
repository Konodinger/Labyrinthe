package maze;

public class DBox extends EBox{

	/**
	 * Bo�te repr�sentant le d�part.
	 * @param x Coordonn�e verticale.
	 * @param y Coordonn�e horizontale.
	 */
	public DBox(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Retourne le label de la bo�te.
	 */
	@Override
	public String getLabel() {
		return "D";
	}
}
