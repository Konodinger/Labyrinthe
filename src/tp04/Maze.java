package tp04;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

public class Maze implements GraphInterface{
	//Le labyrinthe est entièrement défini par son tableau de case
	private ArrayList<ArrayList<MBox>> laby;
	private int width;
	private int height;
	
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
	
	public final void initFromTextFile(String fileName) {
		BufferedReader text = null;
		int colonne = 0;
		try {
			// Mesure de la largeur
			Reader file = new FileReader(fileName);
			text = new BufferedReader(file);
			String ligne = text.readLine();
			width = ligne.length();
			// Lecture  du fichier et mesure de la hauteur
			height = 0;
			file = new FileReader(fileName);
			text = new BufferedReader(file);
			ArrayList<MBox> array;
			while ((ligne = text.readLine()) != null) {
				height ++;
				array = new ArrayList<MBox>();
				if (ligne.length() != width) {
					throw new MazeReadingException(fileName, height, "la largeur du labyrinthe lu n'est pas constante.");
				};
				for (colonne = 0; colonne < width; colonne ++) {
					switch (ligne.charAt(colonne)) {
					case 'E':
						array.add(new EBox(height - 1, colonne));
						break;
					case 'W':
						array.add(new WBox(height - 1, colonne));
						break;
					case 'D' :
						array.add(new DBox(height - 1, colonne));
						break;
					case 'A' :
						array.add(new ABox(height - 1, colonne));
						break;
					default :
						throw new MazeReadingException(fileName, height, "la case de coordonnées (" + Integer.toString(height) + "," + Integer.toString(colonne + 1) + ") n'est pas traduisible en MBox.");
					}
				}
				System.out.println("Ligne " + Integer.toString(height) + " lue !");
				laby.add(array);
			}		
		} catch(FileNotFoundException e) {
			System.out.println("Erreur : fichier introuvable. Vérifier l'adresse du fichier : " + fileName);
			System.out.println(e);
		} catch(IOException e) {
			System.out.println("Erreur : problème avec l'ouverture du fichier");
			System.out.println(e);
		} catch(MazeReadingException e) {
			System.out.println(e);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erreur en lisant la case de coordonnées (" + Integer.toString(height) + "," + Integer.toString(colonne + 1) + ") : la case est introuvable.");
			System.out.println(e);
		} finally {
			try {
				text.close();
				System.out.println("Fermeture du fichier à l'adresse " + fileName);
			} catch(IOException e) {
			System.out.println("Erreur : problème avec la fermeture du fichier");
			System.out.println(e);
			}
		}
	}
	
	public final void saveToTextFile(String fileName) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(fileName);
			for (int ligne = 0; ligne < height; ligne++) {
				System.out.println("Sauvegarde de la ligne " + Integer.toString(ligne + 1) + "...");
				for (int colonne = 0; colonne < width; colonne++) {
					pw.print(laby.get(ligne).get(colonne).getLabel());
				};
				pw.println();
			};
		System.out.println("Sauvegarde terminée !");
		} catch (FileNotFoundException e) {
			System.out.println("Erreur : Impossible d'ouvrir ou bien d'écrire le fichier  à l'emplacement" + fileName + ".");
			System.out.println(e);
		} catch (SecurityException e) {
			System.out.println("Erreur : accès à l'écriture d'un fichier à l'emplacement " + fileName + " refusé.");
			System.out.println(e);
		} finally {
			try {
				pw.close();
				System.out.println("Fermeture du fichier à l'adresse " + fileName);
			} catch(Exception e) {
			System.out.println("Erreur : problème avec la fermeture du fichier");
			System.out.println(e);
			}
		}
	}
}