package b.StacksAndQueues;

public class QueueList {
    private Node first;
    private Node last;

    private static class Node {
        private String item;
        private Node next;
    }

    public void put(final String item) {
        Node old = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else old.next = last;
    }

    public String poll() {
        String item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        return  item;
    }

    private boolean isEmpty() {
        return first == null;
    }

}
