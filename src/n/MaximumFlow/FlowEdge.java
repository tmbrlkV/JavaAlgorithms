package n.MaximumFlow;

public class FlowEdge {
    private int v, w;
    private double capacity;
    private double flow;

    public FlowEdge(int v, double capacity, int w) {
        this.v = v;
        this.capacity = capacity;
        this.w = w;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double capacity() {
        return capacity;
    }

    public double flow() {
        return flow;
    }

    public int other(int v) {
        if (this.v == v) {
            return w;
        }
        return v;
    }

    public double residualCapacity(int vertex) {
        if (vertex == v) {
            return flow;
        }
        return capacity - flow;
    }

    public void addResidualFlowTo(int vertex, double delta) {
        if (vertex == v) {
            flow -= delta;
        } else if (vertex == w) {
            flow += delta;
        }
    }
}
