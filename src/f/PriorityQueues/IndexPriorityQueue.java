package f.PriorityQueues;

import java.util.Iterator;

public class IndexPriorityQueue <Key extends Comparable<Key>> {
    private int max;
    private int size;
    private int[] pq;
    private int[] qp;
    private Key[] keys;

    public IndexPriorityQueue(int max) {
        this.max = max;
        keys = (Key[]) new Comparable[max + 1];
        pq = new int[max + 1];
        qp = new int[max + 1];
        for (int i = 0; i <= max; ++i) {
            qp[i] = -1;
        }
    }

    public boolean contains(int i) {
        return qp[i] != -1;
    }

    public void insert(int i, Key key) {
        if (contains(i)) {
            return;
        }
        size++;
        qp[i] = size;
        pq[size] = i;
        keys[i] = key;
        swim(size);
    }

    private void swim(int k) {
        while (k > 1 && isGreat(k / 2, k)) {
            swap(k / 2, k);
            k /= 2;
        }
    }

    public int deleteMin() {
        int min = pq[1];
        swap(1, size--);
        sink(1);
        qp[min] = -1;
        keys[min] = null;
        pq[size + 1] = -1;
        return min;
    }

    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && isGreat(j, j + 1)) {
                j++;
            }
            if (!isGreat(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private boolean isGreat(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void swap(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public void changeKey(int i, Key key) {
        if (!contains(i)) {
            return;
        }
        keys[i] = key;
        swim(qp[i]);
        sink(qp[i]);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void decreaseKey(int w, Key key) {
        if (!contains(w)) {
            return;
        }
        if (keys[w].compareTo(key) >= 0) {
            return;
        }
        keys[w] = key;
        swim(qp[w]);
    }
}
