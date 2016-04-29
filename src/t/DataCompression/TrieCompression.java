package t.DataCompression;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class TrieCompression {
    private static final char R = 256;
    private Queue<Boolean> in = new ArrayDeque<>();
    private Queue<Character> ch = new ArrayDeque<>();

    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left;
        private final Node right;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    public void compress(String s) {
        char[] input = s.toCharArray();
        int[] freq = new int[R];
        for (int i = 0; i < input.length; ++i) {
            freq[input[i]]++;
        }
        Node root = buildTrie(freq);
        String[] st = new String[R];
        buildCode(st, root, "");
        writeTrie(root);
        for (int i = 0; i < input.length; i++) {
            String code = st[input[i]];
            for (int j = 0; j < code.length(); j++) {
                if (code.charAt(j) == '0') {
                    in.offer(false);
                }
                else if (code.charAt(j) == '1') {
                    in.offer(true);
                }
            }
        }
    }

    private void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.ch] = s;
        }
    }

    public Queue<Character> expand() {
        Node root = readTrie();
        Queue<Character> ch = new ArrayDeque<>();
        int N = in.size();
        for (int i = 0; i < N; ++i) {
            Node x = root;
            while (!x.isLeaf()) {
                if (!in.poll()) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
            ch.offer(x.ch);
        }
        return ch;
    }

    private Node readTrie() {
        if (in.poll()) {
            char c = ch.poll();
            return new Node(c, 0, null, null);
        }
        Node x = readTrie();
        Node y = readTrie();
        return new Node('\0', 0, x, y);
    }

    private void writeTrie(Node x) {
        if (x.isLeaf()) {
            in.offer(true);
            ch.offer(x.ch);
            return;
        }
        in.offer(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    private Node buildTrie(int[] freq) {
        Queue<Node> pq = new PriorityQueue<>();
        for (char i = 0; i < R; ++i) {
            if (freq[i] > 0) {
                pq.offer(new Node(i, freq[i], null, null));
            }
        }
        while (pq.size() > 1) {
            Node x = pq.remove();
            Node y = pq.remove();
            Node parent = new Node('\0', x.freq + y.freq, x, y);
            pq.offer(parent);
        }

        return pq.remove();
    }
}
