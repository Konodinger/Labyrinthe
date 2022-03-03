package maze;
//Classe générant une exception peresonnalisée lors de la lecture du fichier
public class MazeReadingException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String fileName;
	private int errorLine;
	private String message;
	
	public MazeReadingException(String fileName, int errorLine, String message) {
		super("Erreur durant la lecture du fichier" + fileName + "\nà la ligne " + Integer.toString(errorLine) + " : " + message);
		this.fileName = fileName;
		this.errorLine = errorLine;
		this.message = message;
	}
}