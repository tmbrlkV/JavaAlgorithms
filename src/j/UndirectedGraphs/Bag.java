package j.UndirectedGraphs;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {
    private Node<T> first;
    private int size;

    private static class Node<T> {
        private Node<T> next;
        T item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void add(T item) {
        Node<T> old = first;
        first = new Node<>();
        first.item = item;
        first.next = old;
        size++;
    }

    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
    }

    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;

        public ListIterator(Node<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw  new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
