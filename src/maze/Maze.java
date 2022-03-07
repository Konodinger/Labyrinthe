package maze;
import java.io.BufferedReader;
import java.io.File;
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
	//Le labyrinthe est enti�rement d�fini par son tableau de cases.
	private ArrayList<ArrayList<MBox>> laby;
	private int width;
	private int height;
	private ArrayList<VertexInterface> liste;
	private DBox depart;
	private ABox arrivee;
	private boolean highlighted;
	private boolean isSaved;
	private ArrayList<ChangeListener> listeners = new ArrayList<ChangeListener>();
	
	/**
	 * Initialise le labyrinthe � partir d'un double tableau.
	 * @param laby Double tableau de bo�tes.
	 * @throws Exception Le double tableau n'est pas conforme � la construction d'un labyrinthe.
	 */
	public Maze(ArrayList<ArrayList<MBox>> laby) throws Exception{
		this.laby = laby;
		liste = new ArrayList<VertexInterface>();
		depart = null;
		arrivee = null;
		height = laby.size();
		highlighted = false;
		isSaved = false;
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
								throw new Exception("Erreur : au moins deux cases d�part ont �t� trouv�es.");
							}
						}
						if (box.getLabel().equals("A")) {
							if (arrivee == null) {
								arrivee = (ABox) box;
							} else {
								throw new Exception("Erreur : au moins deux cases arriv�e ont �t� trouv�es.");
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
	
	/**
	 * Getter du double tableau.
	 * @return Double tableau de bo�tes.
	 */
	public ArrayList<ArrayList<MBox>> getLaby() {
		return laby;
	}

	/**
	 * Getter de la liste de bo�tes.
	 * @return Liste ordonn�e des bo�tes du double tableau.
	 */
	public ArrayList<VertexInterface> vertexList() {
		return liste;
	}
	
	/**
	 * Getter de la bo�te d�part.
	 * @return Bo�te d�part.
	 */
	public DBox getDepart() {
		return depart;
	}
	
	/**
	 * Getter de la bo�te arriv�e.
	 * @return Bo�te arriv�e.
	 */
	public ABox getArrivee() {
		return arrivee;
	}
	
	/**
	 * Getter de la largeur du labyrinthe.
	 * @return Largeur du labyrinthe.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Getter de la hauteur du labyrinthe.
	 * @return Hauteur du labyrinthe.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Indique la taille du labyrinthe en nombre de bo�tes.
	 * @return Taille du labyrinthe.
	 */
	public int length() {
		return height*width;
	}
	
	/**
	 * Getter du surlignage.
	 * @return Surlignage du labyrinthe.
	 */
	public boolean getHighlighted() {
		return highlighted;
	}
	
	/**
	 * Getter indiquant si le labyrinthe actuel est sauvegard�.
	 * @return Etat de sauvegarde du labyrinthe.
	 */
	public boolean isSaved() {
		return isSaved;
	}

	/**
	 * Setter de l'�tat de sauvegarde du labyrinthe.
	 * @param isSaved Nouvel �tat de sauvegarde du labyrinthe.
	 */
	public void setSaved(boolean isSaved) {
		this.isSaved = isSaved;
	}
	
	/**
	 * Ajoute un observer.
	 * @param listener Nouvel observer.
	 */
	public void addObserver(ChangeListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Pr�viens les observers que l'�tat du labyrinthe a chang�.
	 */
	public void stateChanges() {
		ChangeEvent ev = new ChangeEvent(this);
		for (ChangeListener listener : listeners) {
			listener.stateChanged(ev);
		}
	}

	/**
	 * Indique les voisins d'une bo�te. Attention � bien convertir la MBox en VertexInterface.
	 * @param sommet Bo�te du labyrinthe.
	 * @return Liste des voisins de sommet.
	 */
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

	/**
	 * Retourne le compl�mentaire d'un ensemble de bo�te du labyrinthe.
	 * @param A Ensemble de bo�tes du labyrinthe.
	 * @return Ensemble compl�mentaire.
	 */
	public ArrayList<VertexInterface> notIn(ASetInterface A) {
		ArrayList<VertexInterface> notA = new ArrayList<VertexInterface>();
		for (VertexInterface box : liste) {
			if (!(A.isInSet(box))) {
				notA.add(box);
			}
		}
		return notA;
	}

	/**
	 * Retourne le poids entre deux bo�tes du labyrinthe.
	 * @param a Premi�re bo�te.
	 * @param b Seconde bo�te.
	 * @return p(a,b) : 1 si les cases sont voisines, +infini sinon.
	 */
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
	
	/**
	 * Change le type d'une bo�te du labyrinthe : EBox si elle �tait WBox, et WBox sinon.
	 * @param x Coordonn�e verticale.
	 * @param y Coordonn�e horizontale.
	 */
	public void changeBoxEW(int x, int y) {
		MBox box;
		switch (laby.get(x).get(y).getLabel()) {
		case "W" :
			laby.get(x).set(y, box = new EBox(x, y));
			break;
		case "A" :
			arrivee = null;
		case "D" :
			depart = null;
		default :
			laby.get(x).set(y, box = new WBox(x, y));
		}
		liste.set(x*width + y, box);
		stateChanges();
	}
	
	/**
	 * Change le type d'une bo�te du labyrinthe en DBox. Si une DBox existait d�j�, celle-ci est convertie en EBox.
	 * @param x Coordonn�e verticale.
	 * @param y Coordonn�e horizontale.
	 */
	public void changeBoxD(int x, int y) {
		DBox dBox;
		if (depart != null) {
			int xD = depart.getX();
			int yD = depart.getY();
			EBox eBox;
			laby.get(xD).set(yD, eBox = new EBox(xD, yD));
			liste.set(xD*width + yD, eBox);
		}
		if (laby.get(x).get(y) == arrivee) {
			arrivee = null;
		}
		laby.get(x).set(y, dBox = new DBox(x, y));
		liste.set(x*width + y, dBox);
		depart = dBox;
		stateChanges();
	}
	
	/**
	 * Change le type d'une bo�te du labyrinthe en ABox. Si une ABox existait d�j�, celle-ci est convertie en EBox.
	 * @param x Coordonn�e verticale.
	 * @param y Coordonn�e horizontale.
	 */
	public void changeBoxA(int x, int y) {
		ABox aBox;
		if (arrivee != null) {
			int xA = arrivee.getX();
			int yA = arrivee.getY();
			EBox eBox;
			laby.get(xA).set(yA, eBox = new EBox(xA, yA));
			liste.set(xA*width + yA, eBox);
		}
		if (laby.get(x).get(y) == depart) {
			depart = null;
		}
		laby.get(x).set(y, aBox = new ABox(x, y));
		liste.set(x*width + y, aBox);
		arrivee = aBox;
		stateChanges();
	}
	
	/**
	 * R�soud le labyrinthe par l'algorithme de Dijkstra et surligne le chemin-solution s'il existe.
	 * @return La r�solvabilit� du labyrinthe.
	 */
	public boolean resolve() {
		if ((depart != null) && (arrivee != null)) {
			final Previous previous = (Previous) Dijkstra.dijkstra((GraphInterface) this, (VertexInterface) depart);
			//Trac� du chemin
			return (path(previous));
		}
		return false;
	}
	
	/**
	 * Surligne le chemin entre le d�part et l'arriv�e � l'aide de la table de hashage previous.
	 * @param previous Table de hashage indiquant le pr�decesseur d'une bo�te.
	 * @return La resolvabilit� du labyrinthe.
	 */
	public boolean path(Previous previous) {
		MBox chemin = (MBox) previous.getPrevious(arrivee);
		int securite = height*width;
		while ((chemin != depart) && (chemin != null) && (securite > 0)) {
			chemin.setHighlight(true);
			chemin = (MBox) previous.getPrevious(chemin);
			securite--;
		}
		highlighted = true;
		stateChanges();
		return (chemin == depart);
	}
	
	/**
	 * Efface le sulignage du labyrinthe.
	 */
	public void eraseHighlight() {
		for (VertexInterface box : liste) {
			((MBox) box).setHighlight(false);
		}
		highlighted = false;
		stateChanges();
	}
	
	/**
	 * V�rifie si le string est valide en tant que nom de fichier.
	 * @param fileName Nom du fichier.
	 * @return La validit� du nom de fichier.
	 */
	public boolean isValidFileName(final String fileName) {
	    final File aFile = new File(fileName);
	    try {
	        if (aFile.createNewFile()) {
	            aFile.delete();
	        }
	    } catch (IOException e) {
	        return false;
	    }
	    return true;
	}
	
	/**
	 * Initialise le labyrinthe � partir d'un fichier.
	 * @param fileName Nom du fichier. Le fichier doit �tre un .txt (� ne pas ajouter) et se trouver dans le dossier data/.
	 * @return La r�ussite de l'initialisation.
	 * @throws IOException Le programme ne parvient pas � ouvrir ou fermer le fichier.
	 * @throws MazeReadingException Le programme ne parvient pas � traduire le fichier en labyrinthe.
	 */
	public boolean initFromTextFile(String fileName) throws IOException, MazeReadingException {
		if (isValidFileName(fileName)) {
			BufferedReader text = null;
			int colonne = 0;
			MBox box;
			liste = new ArrayList<VertexInterface>();
			fileName = "data/" + fileName + ".txt";
			
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
							throw new MazeReadingException(fileName, height, "la case de coordonn�es (" + Integer.toString(height) + "," + Integer.toString(colonne) + ") n'est pas traduisible en MBox.");
						}
						array.add(box);
						liste.add(box);
						
					}
					laby.add(array);
					height ++;
				}
				isSaved = true;
			} catch(FileNotFoundException e) {
				System.out.println("Erreur : fichier introuvable. V�rifier l'adresse du fichier : " + fileName);
				System.out.println(e);
				throw e;
			} catch(IOException e) {
				System.out.println("Erreur : probl�me avec l'ouverture du fichier");
				System.out.println(e);
				throw e;
			} catch(MazeReadingException e) {
				throw e;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Erreur en lisant la case de coordonn�es (" + Integer.toString(height) + "," + Integer.toString(colonne) + ") : la case est introuvable.");
				System.out.println(e);
				throw e;
			} finally {
				try {
					highlighted = false;
					stateChanges();
					text.close();
				} catch(IOException e) {
				System.out.println("Erreur : probl�me avec la fermeture du fichier");
				System.out.println(e);
				throw e;
				}
			}
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Sauvegarde le labyrinthe dans un fichier
	 * @param fileName Emplacement du fichier dans lequel sauvegarder le labyrinthe.Le fichier sera un .txt (� ne pas ajouter) et se trouvera dans le dossier data/.
	 * @return La r�ussite de la sauvegarde.
	 * @throws FileNotFoundException Le programme ne parvient pas � ouvrir ou fermer le fichier.
	 */
	public boolean saveToTextFile(String fileName) throws FileNotFoundException {
		if (isValidFileName(fileName)) {
			PrintWriter pw = null;
			int ligne = 0;
			int colonne = 0;
			fileName = "data/" + fileName + ".txt";
			try {
				pw = new PrintWriter(fileName);
				for (ligne = 0; ligne < height; ligne++) {
					for (colonne = 0; colonne < width; colonne++) {
						pw.print(laby.get(ligne).get(colonne).getLabel());
					};
					pw.println();
				};
				isSaved = true;
			} catch (FileNotFoundException e) {
				System.out.println("Erreur : Impossible d'ouvrir ou bien d'�crire le fichier � l'emplacement" + fileName + ".");
				throw e;
			} catch (SecurityException e) {
				System.out.println("Erreur : acc�s � l'�criture d'un fichier � l'emplacement " + fileName + " refus�.");
				throw e;
			} catch (NullPointerException e) {
				System.out.println("Erreur : la case de coordonn�es (" + Integer.toString(ligne) + "," + Integer.toString(colonne) + ") est null, elle ne peut �tre enregistr�e.");
				throw e;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Erreur : la ligne num�ro " + Integer.toString(ligne) + " poss�de un nombre insuffisant de cases.");
				throw e;
			} finally {
				try {
					pw.close();
				} catch(Exception e) {
				System.out.println("Erreur : probl�me avec la fermeture du fichier");
				throw e;
				}
			}
			return true;
		} else {
			return false;
		}
	}

}