package l.MinimumSpanningTrees;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrim {
    private boolean[] marked;
    private Queue<Edge> mst;
    private Queue<Edge> pq;

    public LazyPrim(EdgeWeightedGraph G) {
        pq = new PriorityQueue<>();
        mst = new ArrayDeque<>();
        marked = new boolean[G.V()];
        visit(G, 0);

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) {
                continue;
            }
            mst.offer(e);
            if (!marked[v]) {
                visit(G, v);
            }
            if (!marked[w]) {
                visit(G, w);
            }
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e: G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.offer(e);
            }
        }
    }

    public Iterable<Edge> mst() {
        return mst;
    }
}
