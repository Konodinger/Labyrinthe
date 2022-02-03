package dijkstra;

import java.util.ArrayList;

public class Dijkstra{
	public static PreviousInterface dijkstra(GraphInterface g,
									   VertexInterface r,
									   ASetInterface a,
									   PiInterface pi,
									   PreviousInterface previous) {
		a.setAdd(r);
		VertexInterface pivot = r;
		double poidsPivot;
		pi.set(r, 0);
		int n = g.length();
		ArrayList<VertexInterface> listeSommets = g.vertexList();
		double pArete;
		for (VertexInterface i : listeSommets) {
			if (i != r) pi.set(i, Double.POSITIVE_INFINITY);
		}
		for (int j = 1; j < n; j++) {
			poidsPivot = pi.get(pivot);
			for (VertexInterface y : g.successorVertex(pivot)) {
				pArete = g.p(pivot, y);
				if (!a.isInSet(y) && (pArete + poidsPivot < pi.get(y))) {
					pi.set(y, pArete + poidsPivot);
					previous.setPrevious(y, pivot);
				}
			ArrayList<VertexInterface> B = g.notIn(a);
			pivot = pi.minOfSet(B);
			a.setAdd(pivot);
			}
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
