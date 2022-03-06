package tp04;

import java.util.ArrayList;

import dijkstra.ASet;
import dijkstra.Dijkstra;
import dijkstra.GraphInterface;
import dijkstra.Previous;
import dijkstra.PreviousInterface;
import dijkstra.VertexInterface;
import frame.MazeApp;
import maze.ABox;
import maze.DBox;
import maze.MBox;
import maze.Maze;

public class MainTest {
	
	private static String file = "labyrinthe";
	private static Maze maze;
	
	public static void main(String[] args) {
		
		//Manipulation du labyrinthe
		try {
			
			/*Test des méthodes length et successorVertex :
			System.out.println(maze.length());
			private ArrayList<VertexInterface> neighbors = maze.successorVertex(maze.getLaby().get(6).get(7)); 
			for (VertexInterface vertex : neighbors) {
				MBox box = (MBox) vertex;
				System.out.println("Case de type " + box.getLabel() + ", de coordonnées (" + Integer.toString(box.getX()) + "," + Integer.toString(box.getY()) + ").");
				}*/
			
			/*Test des méthodes vertexList et notIn :
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
			
			//Chargement du labyinthe à  partir d'un fichier
			mazeInit();
			
			//Resolution du labyrinthe
			//maze.resolve();
			
			//Impression de dijkstra
			mazePrint();
			
			//Sauvegarde du labyrinthe
			mazeSave();
			
			//Création de l'IHM
			new MazeApp(maze);
			
		} catch (Exception e) {
			System.out.println("Erreur durant la manipulation du labyrinthe");
			System.out.println(e);
		}
	}
	
	private static void mazeInit(String adresse) throws Exception {
		try {
			maze = new Maze(new ArrayList<ArrayList<MBox>>());
			maze.initFromTextFile(adresse);
		} catch (Exception e) {
			System.out.println("Erreur durant la création du labyrinthe");
			throw e;
		}
	}
	
	private static void mazeInit() throws Exception {
		try {
			mazeInit(file);
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static void mazeSave(String adresse) throws Exception {
		try {
			/*Test de l'erreur de sauvegarde :
			maze.getLaby().get(2).remove(2); */
			maze.saveToTextFile(adresse);
		} catch (Exception e) {
			System.out.println("Erreur durant la sauvegarde du labyrinthe");
			throw e;
		}
	}
	
	private static void mazeSave() throws Exception {
		try {
			mazeSave(file + "-S");
		} catch (Exception e) {
			throw e;
		}
	}
	
	private static void mazePrint() {
		for (ArrayList<MBox> ligne : maze.getLaby()) {
			for (MBox box : ligne) {
				if (box.getHighlight()) {
					System.out.print(".");
				} else {
					System.out.print(box.getLabel());
				}
			}
			System.out.println();
		}
	}
	

}
