package j.UndirectedGraphs;

import java.util.Stack;

public class DFS {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DFS(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
//        dfs(G, s);
        dfsNoRec(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }

    private void dfsNoRec(Graph G, int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        marked[v] = true;
        while (!stack.empty()) {
            int k = stack.pop();
            for (int w : G.adj(k)) {
                if (!marked[w]) {
                    stack.push(w);
                    marked[w] = true;
                    edgeTo[w] = k;
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
