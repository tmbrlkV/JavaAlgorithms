package k.DirectedGraphs;

import java.util.Stack;

public class DigraphDFS {
    private boolean[] marked;

    public DigraphDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        marked[s] = true;
        while (!stack.empty()) {
            int v = stack.pop();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    stack.push(w);
                    marked[w] = true;
                }
            }
        }
    }
}
