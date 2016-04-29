package g.ElementarySymbolTables;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private static class Node<Key, Value> {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " " + value;
        }
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

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }
    ///TODO: NOT RECURSIVE
    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int compared = key.compareTo((Key) node.key);
        if (compared < 0) {
            node.left = put(node.left, key, value);
        } else if (compared > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.count;
    }

    public int size() {
        return size(root);
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if (node == null) {
            return null;
        }
        return (Key) node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int compared = key.compareTo((Key) node.key);
        if (compared == 0) {
            return node;
        }
        if (compared < 0) {
            return floor(node.left, key);
        }
        Node temp = floor(node.right, key);
        if (temp != null) {
            return temp;
        } else {
            return node;
        }
    }

    public Key celling(Key key) {
        Node node = celling(root, key);
        if (node == null) {
            return null;
        }
        return (Key) node.key;
    }

    private Node celling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int compared = key.compareTo((Key) node.key);
        if (compared == 0) {
            return node;
        }
        if (compared > 0) {
            return celling(node.right, key);
        }
        Node temp = celling(node.left, key);
        if (temp != null) {
            return temp;
        } else {
            return node;
        }
    }

    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node node) {
        if (node == null) {
            return 0;
        }
        int compared = key.compareTo((Key) node.key);
        if (compared < 0) {
            return rank(key, node.left);
        } else if (compared > 0) {
            return 1 + size(node.left) + rank(key, node.right);
        } else {
            return size(node.left);
        }
    }

    public Iterable<Key> print() {
        Queue<Key> q = new ArrayDeque<>();
        print(root, q);
        return  q;
    }

    private void print(Node current, Queue<Key> q) {
        if (current == null) {
            return;
        }
        print(current.left, q);
        q.offer((Key) current.key);
        print(current.right, q);

    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left)  + size(x.right);
        return x;
    }

    public  void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int compared = key.compareTo((Key) x.key);
        if (compared < 0) {
            x.left = delete(x.left, key);
        } else if (compared > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return  x.right;
            }

            Node temp = x;
            x = min(temp.right);
            x.right = deleteMin(temp.right);
            x.left = temp.left;
        }
        x.count = size(x.left) + size(x.right) + 1;
        return  x;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        x.left = min(x.left);
        return x;
    }


}
