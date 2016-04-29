package k.DirectedGraphs;

import java.util.Stack;

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        Digraph reverse = G.reverse();
        TopologicalSorting rev = new TopologicalSorting(reverse);
        for (int v : rev.reverse()) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }


    }

    private void dfs(Digraph G, int s) {
        marked[s] = true;
        id[s] = count;
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while (!stack.empty()) {
            int v = stack.pop();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    id[w] = count;
                    stack.push(w);
                }
            }
        }
    }
}
