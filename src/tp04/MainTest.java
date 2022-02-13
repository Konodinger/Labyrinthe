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

	public static void main(String[] args) {
		final Maze maze = new Maze(new ArrayList<ArrayList<MBox>>());
		try {
			maze.initFromTextFile("data/labyrinthe.txt");			
		} catch (Exception e) {
			System.out.println("Erreur durant la cr�ation du labyrinthe");
			System.out.println(e);
		}
		
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
			
			DBox depart = maze.getDepart();
			ABox arrivee = maze.getArrivee();
			System.out.println("Lancement de l'algorithme de dijkstra...");
			Previous previous = (Previous) Dijkstra.dijkstra((GraphInterface) maze, (VertexInterface) depart);
			System.out.println("Algorithme de dijkstra effectu� !");
			
			//Trac� du chemin
			MBox chemin = (MBox) previous.getPrevious(arrivee);
			while ((chemin != depart) && (chemin != null)) {
				chemin.setHighlight(true);
				chemin = (MBox) previous.getPrevious(chemin);
			}
			if (chemin == depart) {
				System.out.println("Chemin le plus court trac� !");
			} else {
				System.out.println("Erreur : impossible de tracer le plus court chemin. Il semble que le labyrinthe ne soit pas r�solvable...");
			}
			
			//Impression de dijkstra
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
		} catch (Exception e) {
			System.out.println("Erreur durant la manipulation du labyrinthe");
			System.out.println(e);
		}
		
		try {
			/*Test de l'erreur de sauvegarde :
			maze.getLaby().get(2).remove(2); */
			maze.saveToTextFile("data/labyrinthe-S.txt");
		} catch (Exception e) {
			System.out.println("Erreur durant la sauvegarde du labyrinthe");
			System.out.println(e);
		}
	}

}
