package f.PriorityQueues;

public class PriorityQueueUnOrder {
    private Comparable[] array;
    private int size;

    public PriorityQueueUnOrder(Comparable[] array) {
        this.array = array.clone();
    }

    public void insert(Comparable item) {
        array[size++] = item;
    }

    public Comparable deleteMax() {
        int max = 0;
        for (int i = 1; i < size; ++i) {
            if (isLess(array[max], array[i])) {
                max = i;
            }
        }
        swap(max, size - 1);
        return array[--size];
    }

    private void swap(final int i, final int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
