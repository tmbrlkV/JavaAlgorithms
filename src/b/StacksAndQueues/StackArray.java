package b.StacksAndQueues;

public class StackArray {
    private Integer[] data;
    private int size;

    public StackArray(final int size) {
        data = new Integer[size];
    }

    public void push(final int item) {
        if (size == data.length) {
            upSize();
        }
        data[size++] = item;
    }

    private void upSize() {
        Integer[] temp = new Integer[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    public Integer pop() {
        if (isEmpty()) return  null;
        Integer i = data[--size];
        data[size] = null;
        if (size > 0 && size == data.length / 4) {
            resize(data.length / 2);
        }
        return i;
    }

    private void resize(final int capacity) {
        Integer[] temp = new Integer[capacity];
        System.arraycopy(data, 0, temp, 0, capacity);
        data = temp;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
