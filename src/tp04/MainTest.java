package tp04;

import java.util.ArrayList;

import dijkstra.ASet;
import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import dijkstra.Previous;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import maze.ABox;
import maze.DBox;
import maze.MBox;
import maze.Maze;

public class MainTest {
	
	private static String file = "data/labyrinthe";
	private static Maze maze;
	
	public static void main(String[] args) {
		
		//Manipulation du labyrinthe
		try {
			
			/*Test des m�thodes length et successorVertex :
			System.out.println(maze.length());
			private ArrayList<VertexInterface> neighbors = maze.successorVertex(maze.getLaby().get(6).get(7)); 
			for (VertexInterface vertex : neighbors) {
				MBox box = (MBox) vertex;
				System.out.println("Case de type " + box.getLabel() + ", de coordonn�es (" + Integer.toString(box.getX()) + "," + Integer.toString(box.getY()) + ").");
				}*/
			
			/*Test des m�thodes vertexList et notIn :
			for (VertexInterface box : maze.vertexList()) {
				System.out.print(box.getLabel());
			}
			System.out.println();
			ASet A = new ASet();
			for (VertexInterface box : maze.getLaby().get(2)) {
				A.setAdd(box);
			}
			for (VertexInterface box : maze.notIn(A)) {
				System.out.print(box.getLabel());
			}
			System.out.println();*/
			
			//Chargement du labyinthe à partir d'un fichier
			mazeInit(file);
			
			//Resolution du labyrinthe
			mazeResolve();
			
			//Impression de dijkstra
			mazePrint();
			
			//Sauvegarde du labyrinthe
			mazeSave(file + "-S");
			
		} catch (Exception e) {
			System.out.println("Erreur durant la manipulation du labyrinthe");
			System.out.println(e);
		}
	}
	
	private static void mazeInit(String adresse) throws Exception {
		try {
			maze = new Maze(new ArrayList<ArrayList<MBox>>());
			maze.initFromTextFile(adresse + ".txt");
		} catch (Exception e) {
			System.out.println("Erreur durant la cr�ation du labyrinthe");
			throw e;
		}
	}
	
	private static void mazeSave(String adresse) throws Exception {
		try {
			/*Test de l'erreur de sauvegarde :
			maze.getLaby().get(2).remove(2); */
			maze.saveToTextFile(adresse + ".txt");
		} catch (Exception e) {
			System.out.println("Erreur durant la sauvegarde du labyrinthe");
			throw e;
		}
	}
	
	private static void mazePrint() {
		for (ArrayList<MBox> ligne : maze.getLaby()) {
			for (MBox box : ligne) {
				if (box.getHighlight()) {
					System.out.print("�");
				} else {
					System.out.print(box.getLabel());
				}
			}
			System.out.println();
		}
	}
	
	private static void mazeResolve() {
		final DBox depart = maze.getDepart();
		final ABox arrivee = maze.getArrivee();
		System.out.println("Lancement de l'algorithme de dijkstra...");
		final Previous previous = (Previous) Dijkstra.dijkstra((GraphInterface) maze, (VertexInterface) depart);
		System.out.println("Algorithme de dijkstra effectu� !");
		//Trac� du chemin
		if (mazePath(previous, depart, arrivee)) {
			System.out.println("Le labyrinthe n'est pas résolvable.");
		}
	}
	
	private static boolean mazePath(Previous previous, MBox depart, MBox arrivee) {
		MBox chemin = (MBox) previous.getPrevious(arrivee);
		int securite = maze.length();
		while ((chemin != depart) && (chemin != null) && (securite > 0)) {
			chemin.setHighlight(true);
			chemin = (MBox) previous.getPrevious(chemin);
			securite--;
		}
		if (chemin == depart) {
			System.out.println("Chemin le plus court trac� !");
			return true;
		} else {
			System.out.println("Erreur : impossible de tracer le chemin.");
			return false;
		}
	}

}
