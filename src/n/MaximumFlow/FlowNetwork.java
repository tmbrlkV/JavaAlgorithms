package n.MaximumFlow;

import j.UndirectedGraphs.Bag;

public class FlowNetwork {
    private int V;
    private Bag<FlowEdge>[] adj;

    public FlowNetwork(int v) {
        V = v;
        adj = new Bag[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new Bag<>();
        }
    }

    public void addEdge(FlowEdge e) {
        int v = e.from();
        int w = e.to();
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<FlowEdge> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }
}
