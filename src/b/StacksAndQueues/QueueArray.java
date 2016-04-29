package b.StacksAndQueues;

public class QueueArray {
    private Integer[] data;
    private int size;

    public QueueArray(final int capacity) {
        data = new Integer[capacity];
    }

    public void put(final int item) {
        if (size == data.length) {
            sizeUp();
        }
        data[size++] = item;
    }

    private void sizeUp() {
        Integer[] temp = new Integer[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    public Integer poll() {
        if (isEmpty()) return null;
        int i = data[0];
        size--;
        if (size == data.length / 4) {
            resize();
        }
        shift();
        return i;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void shift() {
        Integer[] temp = new Integer[data.length];
        System.arraycopy(data, 1, temp, 0, data.length - 1);
        data = temp;
    }

    private void resize() {
        Integer[] temp = new Integer[data.length / 2];
        System.arraycopy(data, 0, temp, 0, temp.length);
        data = temp;
    }
}
