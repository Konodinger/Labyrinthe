package maze;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.lang.Math;

import dijkstra.ASetInterface;
import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import dijkstra.Previous;
import dijkstra.VertexInterface;

public class Maze implements GraphInterface{
	//Le labyrinthe est entièrement défini par son tableau de cases.
	private static ArrayList<ArrayList<MBox>> laby;
	private static int width;
	private static int height;
	private static ArrayList<VertexInterface> liste;
	private static DBox depart;
	private static ABox arrivee;
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
	
	public Maze(ArrayList<ArrayList<MBox>> laby) throws Exception{
		Maze.laby = laby;
		liste = null;
		depart = null;
		arrivee = null;
		height = laby.size();
		if (height == 0 ) {
			width = 0;
		} else {
			width = laby.get(0).size();
			for(ArrayList<MBox> ligne : laby) {
				if (ligne.size() == width) {
					for (MBox box : ligne) {
						liste.add(box);
						if (box.getLabel().equals("D")) {
							if (depart == null) {
								depart = (DBox) box;
							} else {
								throw new Exception("Erreur : au moins deux cases départ ont été trouvées.");
							}
						}
						if (box.getLabel().equals("A")) {
							if (arrivee == null) {
								arrivee = (ABox) box;
							} else {
								throw new Exception("Erreur : au moins deux cases arrivée ont été trouvées.");
							}
						}
					}
				} else {
					throw new Exception("Erreur : la largeur du labyrinthe n'est pas constante.");
				}
			}
		}
		stateChanges();
	}
	
	public ArrayList<ArrayList<MBox>> getLaby() {
		return laby;
	}

	public ArrayList<VertexInterface> vertexList() {
		return liste;
	}
	
	public DBox getDepart() {
		return depart;
	}
	
	public ABox getArrivee() {
		return arrivee;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int length() {
		return height*width;
	}
	
	
	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}
	
	public void stateChanges() {
		ChangeEvent ev = new ChangeEvent(this);
		for (ChangeListener listener : listeners) {
			listener.stateChanged(ev);
		}
	}

	
	public ArrayList<VertexInterface> successorVertex(VertexInterface sommet) {
		final MBox box = (MBox) sommet;
		final int x = box.getX();
		final int y = box.getY();
		ArrayList<VertexInterface> voisins = new ArrayList<VertexInterface>();
		if (x > 0) {
			voisins.add(laby.get(x-1).get(y));
		}
		if (y > 0) {
			voisins.add(laby.get(x).get(y-1));
		}
		if (x < height - 1) {
			voisins.add(laby.get(x+1).get(y));
		}
		if (y < width - 1) {
			voisins.add(laby.get(x).get(y+1));
		}
		return voisins;
	}

	public ArrayList<VertexInterface> notIn(ASetInterface A) {
		ArrayList<VertexInterface> notA = new ArrayList<VertexInterface>();
		for (VertexInterface box : liste) {
			if (!(A.isInSet(box))) {
				notA.add(box);
			}
		}
		return notA;
	}

	public double p(VertexInterface a, VertexInterface b) {
		if (!(a.getLabel().equals("W") || b.getLabel().equals("W"))) {
			MBox aBox = (MBox) a;
			MBox bBox = (MBox) b;
			if (Math.abs(aBox.getX() - bBox.getX()) + Math.abs(aBox.getY() - bBox.getY()) == 1) {
				return 1;
			}
		}
		return Double.POSITIVE_INFINITY;
	}
	
	public void Resolve() {
		System.out.println("Lancement de l'algorithme de dijkstra...");
		final Previous previous = (Previous) Dijkstra.dijkstra((GraphInterface) this, (VertexInterface) depart);
		System.out.println("Algorithme de dijkstra effectué !");
		//Tracé du chemin
		if (!Path(previous)) {
			System.out.println("Le labyrinthe n'est pas résolvable.");
		}
	}
	
	public boolean Path(Previous previous) {
		MBox chemin = (MBox) previous.getPrevious(arrivee);
		int securite = height*width;
		while ((chemin != depart) && (chemin != null) && (securite > 0)) {
			chemin.setHighlight(true);
			chemin = (MBox) previous.getPrevious(chemin);
			securite--;
		}
		stateChanges();
		if (chemin == depart) {
			System.out.println("Chemin le plus court tracé !");
			return true;
		} else {
			System.out.println("Erreur : impossible de tracer le chemin.");
			return false;
		}
	}
	
	public void eraseHighlight() {
		for (VertexInterface box : liste) {
			((MBox) box).setHighlight(false);
		}
		stateChanges();
	}
	
	
	public final void initFromTextFile(String fileName) throws IOException, MazeReadingException {
		BufferedReader text = null;
		int colonne = 0;
		MBox box;
		liste = new ArrayList<VertexInterface>();
		try {
			// Mesure de la largeur
			Reader file = new FileReader(fileName);
			text = new BufferedReader(file);
			String ligne = text.readLine();
			width = ligne.length();
			// Lecture  du fichier et mesure de la hauteur
			height = 0;
			laby = new ArrayList<ArrayList<MBox>>();
			file = new FileReader(fileName);
			text = new BufferedReader(file);
				
			ArrayList<MBox> array;
			while ((ligne = text.readLine()) != null) {
				array = new ArrayList<MBox>();
				if (ligne.length() != width) {
					throw new MazeReadingException(fileName, height, "la largeur du labyrinthe lu n'est pas constante.");
				};
				for (colonne = 0; colonne < width; colonne ++) {
					switch (ligne.charAt(colonne)) {
					case 'E':
						box = (EBox) new EBox(height, colonne);
						break;
					case 'W':
						box = (WBox) new WBox(height, colonne);
						break;
					case 'D' :
						box = (DBox) new DBox(height, colonne);
						depart = (DBox) box;
						break;
					case 'A' :
						box = (ABox) new ABox(height, colonne);
						arrivee = (ABox) box;
						break;
					default :
						throw new MazeReadingException(fileName, height, "la case de coordonnées (" + Integer.toString(height) + "," + Integer.toString(colonne) + ") n'est pas traduisible en MBox.");
					}
					array.add(box);
					liste.add(box);
					
				}
				System.out.println("Ligne " + Integer.toString(height) + " lue !");
				laby.add(array);
				height ++;
			}		
		} catch(FileNotFoundException e) {
			System.out.println("Erreur : fichier introuvable. Vérifier l'adresse du fichier : " + fileName);
			System.out.println(e);
			throw e;
		} catch(IOException e) {
			System.out.println("Erreur : problème avec l'ouverture du fichier");
			System.out.println(e);
			throw e;
		} catch(MazeReadingException e) {
			throw e;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erreur en lisant la case de coordonnées (" + Integer.toString(height) + "," + Integer.toString(colonne) + ") : la case est introuvable.");
			System.out.println(e);
			throw e;
		} finally {
			try {
				text.close();
				System.out.println("Fermeture du fichier à l'adresse " + fileName);
				stateChanges();
			} catch(IOException e) {
			System.out.println("Erreur : problème avec la fermeture du fichier");
			System.out.println(e);
			throw e;
			}
		}
	}
	
	public final void saveToTextFile(String fileName) throws FileNotFoundException {
		PrintWriter pw = null;
		int ligne = 0;
		int colonne = 0;
		try {
			pw = new PrintWriter(fileName);
			for (ligne = 0; ligne < height; ligne++) {
				System.out.println("Sauvegarde de la ligne " + Integer.toString(ligne) + "...");
				for (colonne = 0; colonne < width; colonne++) {
					pw.print(laby.get(ligne).get(colonne).getLabel());
				};
				pw.println();
			};
		System.out.println("Sauvegarde terminée !");
		} catch (FileNotFoundException e) {
			System.out.println("Erreur : Impossible d'ouvrir ou bien d'écrire le fichier à l'emplacement" + fileName + ".");
			throw e;
		} catch (SecurityException e) {
			System.out.println("Erreur : accès à l'écriture d'un fichier à l'emplacement " + fileName + " refusé.");
			throw e;
		} catch (NullPointerException e) {
			System.out.println("Erreur : la case de coordonnées (" + Integer.toString(ligne) + "," + Integer.toString(colonne) + ") est null, elle ne peut être enregistrée.");
			throw e;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erreur : la ligne numéro " + Integer.toString(ligne) + " possède un nombre insuffisant de cases.");
			throw e;
		} finally {
			try {
				pw.close();
				System.out.println("Fermeture du fichier à l'adresse " + fileName);
			} catch(Exception e) {
			System.out.println("Erreur : problème avec la fermeture du fichier");
			throw e;
			}
		}
	}
}