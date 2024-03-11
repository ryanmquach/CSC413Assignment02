import java.util.Comparator;
import java.util.Iterator;


public class LListPriorityQueue<T extends BankAccount> implements QueueInterface<T> {

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

    public LListPriorityQueue() {
        front = null;
        size = 0;
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty() || compare(newEntry, front.getData()) < 0) {
            newNode.setNext(front);
            front = newNode;
        } else {
            Node current = front;
            while (current.getNext() != null && compare(newEntry, current.getNext().getData()) >= 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public T remove() {
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
    public int compareTo(T other) {
        return 0;
    }

    // Define a comparator for comparing BankAccount objects based on creation time and balance
    private static final Comparator<BankAccount> COMPARATOR = new Comparator<BankAccount>() {
        @Override
        public int compare(BankAccount o1, BankAccount o2) {
            int compareCreationTime = o1.getCreationTime().compareTo(o2.getCreationTime());
            if (compareCreationTime != 0) {
                return compareCreationTime;
            }
            return Double.compare(o1.getBalance(), o2.getBalance());
        }
    };

    // Utility method to compare two BankAccount objects using the defined comparator
    private int compare(T obj1, T obj2) {
        return COMPARATOR.compare(obj1, obj2);
    }

    @Override
    public Iterator<T> iterator() {
        return new PriorityQueueIterator();
    }

    private class PriorityQueueIterator implements Iterator<T> {
        private Node current = front;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T data = current.getData();
            current = current.getNext();
            return data;
        }
    }
}

