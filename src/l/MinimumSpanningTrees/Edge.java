package l.MinimumSpanningTrees;

public class Edge implements Comparable<Edge> {
    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double wieght) {
        this.v = v;
        this.w = w;
        this.weight = wieght;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) {
            return w;
        }
        return v;
    }

    @Override
    public int compareTo(Edge that) {
        if (this.weight < that.weight) {
            return -1;
        } else if (this.weight > that.weight) {
            return 1;
        } else {
            return 0;
        }
    }

    public double weight() {
        return weight;
    }
}
