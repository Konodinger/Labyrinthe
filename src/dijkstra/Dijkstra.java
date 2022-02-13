package dijkstra;

import java.util.ArrayList;

public class Dijkstra{
	private static PreviousInterface dijkstra(GraphInterface g,
									   VertexInterface r,
									   ASetInterface a,
									   PiInterface pi,
									   PreviousInterface previous) {
		a.setAdd(r);
		VertexInterface pivot = r;
		double poidsPivot;
		int n = g.length();
		ArrayList<VertexInterface> listeSommets = g.vertexList();
		double pArete;
		
		for (VertexInterface i : listeSommets) {
			pi.set(i, Double.POSITIVE_INFINITY);
		}
		pi.set(r, 0);
		
		for (int j = 0; j < n; j++) {
			poidsPivot = pi.get(pivot);
			for (VertexInterface y : g.successorVertex(pivot)) {
				pArete = g.p(pivot, y);
				if (!a.isInSet(y) && (pArete + poidsPivot < pi.get(y))) {
					pi.set(y, pArete + poidsPivot);
					previous.setPrevious(y, pivot);
				}
			}
			ArrayList<VertexInterface> B = g.notIn(a);
			pivot = pi.minOfSet(B);
			//L'algorithme se finit dès qu'il n'y a plus de sommet accessible à une distance finie.
			if (pivot == null) {
				break;
			}
			a.setAdd(pivot);
			
		}
		return previous;
	}
	
	public static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		ASet a = new ASet();
		Pi pi = new Pi();
		Previous previous = new Previous();
		return dijkstra(g, r, a, pi, previous);
	}
}
