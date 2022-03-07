package maze;

public class ABox extends EBox{

	/**
	 * Bo�te repr�sentant l'arriv�e.
	 * @param x Coordonn�e verticale.
	 * @param y Coordonn�e horizontale.
	 */
	public ABox(int x, int y) {
		super(x, y);
	}
	
	/**
	 * Retourne le label de la bo�te.
	 */
	@Override
	public String getLabel() {
		return "A";
	}
}
