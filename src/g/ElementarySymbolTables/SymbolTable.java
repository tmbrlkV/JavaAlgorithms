package g.ElementarySymbolTables;

public class SymbolTable<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int size;
    private boolean exists;

    public void put(Key key, Value value) {
        if (!contains(key)) {
            putNode(key, value);
        }
    }

    private void putNode(Key key, Value value) {
        keys[size] = key;
        values[size++] = value;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < size && this.keys[i].compareTo(key) == 0 && values[i] != null) {
            return values[i];
        }
        return null;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int rank(Key key) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (low - high) / 2;
            int compared = key.compareTo(this.keys[mid]);
            if (compared < 0) {
                high = mid - 1;
            } else if (compared > 0) {
                low = mid + 1;
            } else {
                exists = true;
                return mid;
            }
        }
        return low;
    }

    public void delete(Key key) {
        put(key, null);
    }

    public boolean contains(Key key) {
        rank(key);
        boolean temp = exists;
        exists = false;
        return temp;
    }

    public int size() {
        return 0;
    }
}
