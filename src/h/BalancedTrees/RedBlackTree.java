package h.BalancedTrees;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private static class Node<Key extends Comparable<Key>, Value> {
        Node left;
        Node right;
        Key key;
        Value value;
        boolean color;
        Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return BLACK;
        }
        return x.color == RED;
    }


    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, RED);
        }
        int compared = key.compareTo((Key) h.key);
        if (compared < 0) {
            h.left = put(h.left, key, value);
        } else if (compared > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.left)) {
            flipColors(h);
        }

        return h;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public Value get(Key key) {
        Node current = root;
        while (current != null) {
            int compared = key.compareTo((Key) current.key);
            if (compared < 0) {
                current = current.left;
            } else if (compared > 0) {
                current = current.right;
            } else {
                return (Value) current.value;
            }
        }
        return null;
    }
}
