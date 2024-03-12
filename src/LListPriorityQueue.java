import java.util.Comparator;
import java.util.Iterator;

public class LListPriorityQueue<T extends Comparable<? super T>> implements QueueInterface<T> {

    public class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node front;
    private int size;

    public static LListPriorityQueue instance = null;

    // Private constructor to prevent external instantiation
    private LListPriorityQueue() {
        front = null;
        size = 0;
    }

    // Method to provide a single instance of the class
    public static synchronized LListPriorityQueue getInstance() {
        if (instance == null) {
            instance = new LListPriorityQueue();
        }
        return instance;
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty() || compare(newEntry, front.getData()) > 0) {
            newNode.setNext(front);
            front = newNode;
        } else {
            Node previous = null;
            Node current = front;
            while (current != null && compare(newEntry, current.getData()) <= 0) {
                previous = current;
                current = current.getNext();
            }
            if (previous != null) {
                previous.setNext(newNode);
            } else {
                front = newNode;
            }
            newNode.setNext(current);
        }
        size++;
    }


    private int compare(T obj1, T obj2) {
        return obj1.compareTo(obj2);
    }

    @Override
    public T remove(T obj1) {
        if (isEmpty()) {
            return null;
        }
        T removedData = front.getData();
        front = front.getNext();
        size--;
        return removedData;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return front.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new PQIterator();
    }

    class PQIterator implements Iterator<T> {
        private Node current = front;
        private Node previous = null; // Keep track of the previous node

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.getData();
            previous = current; // Update the previous node
            current = current.getNext();
            return data;
        }

        // Method to reset the iterator to the beginning of the priority queue
        public void reset() {
            current = front;
            previous = null;
        }

        // Method to remove the last iterated element
        public void removeLast() {
            if (previous != null) {
                if (previous == front) {
                    front = front.getNext();
                } else {
                    Node temp = front;
                    while (temp.getNext() != previous) {
                        temp = temp.getNext();
                    }
                    temp.setNext(previous.getNext());
                }
            }
        }
    }
}





