package maze;
//Classe g�n�rant une exception peresonnalis�e lors de la lecture du fichier
public class MazeReadingException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String fileName;
	private int errorLine;
	private String message;
	
	public MazeReadingException(String fileName, int errorLine, String message) {
		super("Erreur durant la lecture du fichier" + fileName + "\n� la ligne " + Integer.toString(errorLine) + " : " + message);
		this.fileName = fileName;
		this.errorLine = errorLine;
		this.message = message;
	}
}