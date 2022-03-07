package maze;
//Classe g�n�rant une exception peresonnalis�e lors de la lecture du fichier
public class MazeReadingException extends Exception{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Retourne un message d'exception adapt� � la lecture d'un fichier.
	 * 
	 * @param fileName Nom du fichier lu.
	 * @param errorLine Ligne du fichier � laquelle l'exception a lieu.
	 * @param message Explications suppl�mentaire quant � la nature de l'exception.
	 */
	public MazeReadingException(String fileName, int errorLine, String message) {
		super("Erreur durant la lecture du fichier" + fileName + "\n� la ligne " + Integer.toString(errorLine) + " : " + message);
	}
}