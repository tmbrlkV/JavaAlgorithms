package p.Tries;

public class TST<Value> {
    private Node<Value> root;

    public String longestPrefixOf(String query) {
        if (query == null || query.length() == 0) {
            return null;
        }
        int length = 0;
        Node<Value> x = root;
        int i = 0;
        while (x != null && i < query.length()) {
            char c = query.charAt(i);
            if (c < x.c) {
                x = x.left;
            } else if (c > x.c) {
                x = x.right;
            } else {
                i++;
                if (x.value != null) {
                    length = i;
                }
                x = x.middle;
            }
        }
        return query.substring(0, length);
    }

    private static class Node<Value> {
        Value value;
        private char c;
        private Node left, middle, right;
    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node<Value> put(Node<Value> x, String key, Value value, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node<>();
            x.c = c;
        }
        if (c < x.c) {
            x.left = put(x.left, key, value, d);
        } else if (c > x.c) {
            x.right = put(x.right, key, value, d);
        } else if (d < key.length() - 1) {
            x.middle = put(x.middle, key, value, d + 1);
        } else {
            x.value = value;
        }
        return x;
    }

    public Value get(String key) {
        Node<Value> x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.value;
    }

    private Node<Value> get(Node<Value> x, String key, int d) {
        if (x == null) {
            return null;
        }
        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left, key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.middle, key, d + 1);
        } else {
            return x;
        }
    }

    public boolean contains(String key) {
        return get(key) != null;
    }
}
