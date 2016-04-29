package a.intro;

public class GraphBalance {
    private int[] size;
    private int[] array;
    private static int LINE;
    private boolean[] isOpen;

    public GraphBalance(final int size) {
        init(size);
        for (int i = 0; i < size; ++i) {
            array[i] = i;
            this.size[i] = i;
        }
        topBot(size);
    }

    private void topBot(final int size) {
        for (int i = 1; i < LINE + 1; ++i) {
            union(0, i);
        }
        for (int i = size - LINE - 2; i < size - 1; ++i) {
            union(size - 1, i);
        }
    }

    private void init(final int size) {
        array = new int[size];
        this.size = new int[size];
        isOpen = new boolean[size];
        LINE = (int) Math.sqrt(array.length - 1);
    }

    public boolean open(final int i) {
        if (!isOpen[i]) {
            isOpen[i] = true;
            bottomNeighbour(i);
            topNeighbour(i);
            leftNeighbour(i);
            rightNeighbour(i);
            return true;
        }
        return false;
    }

    private void rightNeighbour(final int i) {
        if (i + 1 <= array.length - 1 && i % LINE != 0) {
            if (isOpen[i + 1] && !connected(i, i + 1)) {
                union(i, i + 1);
            }
        }
    }

    private void leftNeighbour(final int i) {
        if (i - 1 > 0 && (i - 1) % LINE != 0) {
            if (isOpen[i - 1] && !connected(i, i - 1)) {
                union(i, i - 1);
            }
        }
    }

    private void topNeighbour(final int i) {
        if (i + LINE <= array.length - 1) {
            if (isOpen[i + LINE] && !connected(i, i + LINE)) {
                union(i, i + LINE);
            }
        }
    }

    private void bottomNeighbour(final int i) {
        if (i - LINE > 0) {
            if (isOpen[i - LINE] && !connected(i, i - LINE)) {
                union(i, i - LINE);
            }
        }
    }

    public int root(int i) {
        while (i != array[i]) {
            array[i] = array[array[i]];
            i = array[i];
        }
        return i;
    }

    public boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }

    public void union(final int p, final int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) return;
        if (size[i] < size[j]) {
            array[i] = j;
            size[j] += size[i];
        } else {
            array[j] = i;
            size[i] += size[j];
        }
    }
}
