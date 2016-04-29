package s.RegularExpressions;

import k.DirectedGraphs.Digraph;

import java.util.Stack;

public class DirectedDFS {
    private boolean[] marked;
    public DirectedDFS(Digraph G, int i) {
        marked = new boolean[G.V()];
        dfs(G, i);
    }

    private void dfs(Digraph G, int v) {
        Stack<Integer> st = new Stack<>();
        st.push(v);
        marked[v] = true;
        while (!st.empty()) {
            int w = st.pop();
            for (int k : G.adj(w)) {
                if (!marked[k]) {
                    st.push(k);
                    marked[k] = true;
                }
            }
        }
    }

    public DirectedDFS(Digraph G, Iterable<Integer> match) {
        marked = new boolean[G.V()];
        for (int v : match) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }
}
