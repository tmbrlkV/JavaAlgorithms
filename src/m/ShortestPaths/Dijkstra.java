package m.ShortestPaths;

import f.PriorityQueues.IndexPriorityQueue;

public class Dijkstra {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexPriorityQueue<Double> pq;

    public Dijkstra(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexPriorityQueue<>(G.V());

        for (int v = 0; v < G.V(); ++v) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);

        while (!pq.isEmpty()) {
            int v = pq.deleteMin();
            for (DirectedEdge e: G.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if (pq.contains(w)) {
                pq.decreaseKey(w, distTo[w]);
            } else {
                pq.insert(w, distTo[w]);
            }
        }
    }
}
