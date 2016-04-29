package k.DirectedGraphs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class DigraphBFS {
    private boolean[] marked;

    public DigraphBFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        bfs(G, s);
    }

    private void bfs(Digraph G, int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        marked[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    queue.offer(w);
                    marked[w] = true;
                }
            }
        }
    }
}
