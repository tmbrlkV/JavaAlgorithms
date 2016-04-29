package f.PriorityQueues;

public class BinaryHeap {
    private Comparable[] array;
    private int size;

    public BinaryHeap(final int size) {
        this.array = new Comparable[size + 1];
    }

    public void insert(final Comparable item) {
        array[++size] = item;
        swim(size);
    }
    private void swim(int k) {
        while (k > 1 && isLess(array[k / 2], array[k])) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    public Comparable deleteMax() {
        if (isEmpty()) {
            return 0;
        }
        Comparable max = array[1];
        swap(1, size--);
        sink(1);
        array[size + 1] = null;
        return  max;
    }
    private void sink(int k) {
        while (2 * k <= size) {
            int j = 2 * k;
            if (j < size && isLess(array[j], array[j + 1])) {
                j++;
            }
            if (!isLess(array[k], array[j])) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void swap(final int i, final int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private boolean isLess(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
