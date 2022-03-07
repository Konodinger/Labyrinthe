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
			maze = new Maze(new ArrayList<ArrayList<MBox>>());
			maze.initFromTextFile(file);
			
			//Création de l'IHM
			new MazeApp(maze);
			
		} catch (Exception e) {
			System.out.println("Erreur durant la manipulation du labyrinthe");
			System.out.println(e);
		}
	}

}
