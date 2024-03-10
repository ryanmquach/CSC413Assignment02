import java.util.LinkedList;

public class LListPriorityQueue<T extends BankAccount & Comparable<? super T>> implements QueueInterface<T> {

    public class Node<T> {
        private T data;
        private Node<T> next;

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

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }


    private Node<T> front;
    private int size;

    public LListPriorityQueue() {
        front = null;
        size = 0;
    }

    @Override
    public void add(T newEntry) {
        Node<T> newNode = new Node<>(newEntry);
        if (isEmpty() || newEntry.compareTo(front.getData()) < 0) {
            newNode.setNext(front);
            front = newNode;
        } else {
            Node<T> current = front;
            while (current.getNext() != null && newEntry.compareTo(current.getNext().getData()) >= 0) {
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
    // Implement compareTo method to compare BankAccount objects based on creation time and balance
    @Override
    public int compareTo(T other) {
        // Implement comparison logic for priority based on creation time and balance
        // Compare based on creation time first
        int compareCreationTime = this.peek().getCreationTime().compareTo(other.getCreationTime());
        if (compareCreationTime != 0) {
            return compareCreationTime;
        }

        // If creation times are equal, compare based on balance
        return Double.compare(this.peek().getBalance(), other.getBalance());
    }

}
