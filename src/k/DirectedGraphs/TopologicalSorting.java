package k.DirectedGraphs;

import m.ShortestPaths.DirectedEdge;
import m.ShortestPaths.EdgeWeightedDigraph;

import java.util.Stack;

public class TopologicalSorting {
    private boolean[] marked;
    private Stack<Integer> reverse = new Stack<>();

    public TopologicalSorting(Digraph G) {
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); ++v) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    public TopologicalSorting(EdgeWeightedDigraph G) {
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); ++v) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int s) {
        Stack<Integer> stack = new Stack<>();
        marked[s] = true;
        while (!stack.empty()) {
            int v = stack.pop();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    stack.push(w);
                    marked[w] = true;
                }
            }
            reverse.push(v);
        }
    }

    private void dfs(EdgeWeightedDigraph G, int s) {
        Stack<Integer> stack = new Stack<>();
        marked[s] = true;
        while (!stack.empty()) {
            int v = stack.pop();
            for (DirectedEdge e : G.adj(v)) {
                int w = e.to();
                if (!marked[w]) {
                    stack.push(w);
                    marked[w] = true;
                }
            }
            reverse.push(v);
        }
    }

    public Iterable<Integer> reverse() {
        return reverse;
    }
}
