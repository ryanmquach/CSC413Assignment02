import java.util.Iterator;

public interface QueueInterface<T extends Comparable<? super T>> {
    /** Adds a new entry to this priority queue.
     * @param newEntry an object */
    public void add(T newEntry);

    /** Removes and returns the item with the highest priority.
     * @return either the object with the highest priority or, if the
     * priority queue is empty before the operation, null */
    public T remove(T o);

    /** Retrieves the item with the highest priority.
     * @return either the object with the highest priority or, if the
     * priority queue is empty, null */
    public T peek();

    /** Detects whether this priority queue is empty.
     * @return true if the priority queue is empty, or false otherwise */
    public boolean isEmpty();

    /** Gets the size of this priority queue.
     * @return the number of entries currently in the priority queue */
    public int getSize();

    /** Removes all entries from this priority queue */
    public void clear();

    Iterator<T> iterator();
}




