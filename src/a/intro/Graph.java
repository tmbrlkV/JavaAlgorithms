package a.intro;

public class Graph {
    private int[] array;

    public Graph(final int size) {
        array = new int[size];
        for (int i = 0; i < size; ++i) {
            array[i] = i;
        }
    }

    public int root(int i) {
        while (i != array[i]) {
            i = array[i];
        }
        return i;
    }

    ///not optimal union
    public boolean connected(final int p, final int q) {
        return root(p) == root(q);
    }

    ///not optimal find
    public boolean isConnected(final int p, final int q) {
        return array[p] == array[q];
    }

    ///not optimal find
    public void union(final int p, final int q) {
        int pid = array[p];
        int qid = array[q];
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == pid) {
                array[i] = qid;
            }
        }
    }

    ///not optimal union
    public void goodUnion(final int p, final int q) {
        int i = root(p);
        int j = root(q);
        array[i] = j;
    }
}
