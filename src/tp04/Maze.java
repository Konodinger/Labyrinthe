package tp04;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Maze implements GraphInterface{
	//Le labyrinthe est entièrement défini par son tableau de case
	private ArrayList<ArrayList<MBox>> laby;
	
	public Maze(ArrayList<ArrayList<MBox>> laby) {
		this.laby = laby;
	}
	
	public ArrayList<ArrayList<MBox>> getLaby() {
		return laby;
	}

	public ArrayList<VertexInterface> vertexList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<VertexInterface> successorVertex(VertexInterface sommet) {
		// TODO Auto-generated method stub
		return null;
	}

	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<VertexInterface> notIn(ASetInterface A) {
		// TODO Auto-generated method stub
		return null;
	}

	public double p(VertexInterface x, VertexInterface y) {
		// TODO Auto-generated method stub
		return 0;
	}
	public 
	
	public final void initFromTextFile(String fileName) {
		BufferedReader text = null;
		try {
			final Reader file = new FileReader(fileName);
			text = new BufferedReader(file);
			String ligne = null;
			while ((ligne = text.readLine()) != null) {
				System.out.println(ligne);
			}
		} catch(FileNotFoundException e) {
			System.out.println("Erreur : fichier introuvable. Vérifier l'adresse du fichier : " + fileName);
			System.out.println(e);
		} catch(IOException e) {
			System.out.println("Erreur : problème avec la lecture du fichier");
			System.out.println(e);
		} finally {
			try {
				text.close();
			} catch(IOException e) {
			System.out.println("Erreur : problème avec la fermeture du fichier");
			System.out.println(e);
			}
		}
	}
	
}