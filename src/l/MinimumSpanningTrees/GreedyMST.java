package l.MinimumSpanningTrees;

import a.intro.GraphBalance;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class GreedyMST {
    private Queue<Edge> mst = new ArrayDeque<>();

    public GreedyMST(EdgeWeightedGraph G) {
        Queue<Edge> pq = new PriorityQueue<>();
        for (Edge e: G.edges()) {
            pq.offer(e);
        }
        GraphBalance union = new GraphBalance(G.V());

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if (!union.connected(v, w)) {
                union.union(v, w);
                mst.offer(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }
}
