package maze;
//Classe générant une exception peresonnalisée lors de la lecture du fichier
public class MazeReadingException extends Exception{

	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Retourne un message d'exception adapté à la lecture d'un fichier.
	 * 
	 * @param fileName Nom du fichier lu.
	 * @param errorLine Ligne du fichier à laquelle l'exception a lieu.
	 * @param message Explications supplémentaire quant à la nature de l'exception.
	 */
	public MazeReadingException(String fileName, int errorLine, String message) {
		super("Erreur durant la lecture du fichier" + fileName + "\nà la ligne " + Integer.toString(errorLine) + " : " + message);
	}
}