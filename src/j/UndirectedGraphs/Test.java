package j.UndirectedGraphs;

public class Test {
    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(3, 5);
        g.addEdge(5, 0);
        DFS dfs = new DFS(g, 0);
        for (Integer i: dfs.pathTo(3)) {
            System.out.print(i + " ");
        }
    }
}
