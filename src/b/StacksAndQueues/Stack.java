package b.StacksAndQueues;

public class Stack {
    private int size;
    private Node first;

    private static class Node {
        String item;
        Node next;
    }

    public void push(final String item) {
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
        size++;
    }

    public String pop() {
        if (first == null) return "";
        String item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return  size;
    }
}
