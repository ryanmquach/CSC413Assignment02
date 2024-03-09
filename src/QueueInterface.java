public interface QueueInterface<T> {
    /**
     * Adds an element to the rear of the queue.
     *
     * @param element the element to be added
     */
    void add(T element);

    /**
     * Adds an element to the rear of the queue.
     *
     * @param element the element to be added
     * @return true if the element was added successfully, false otherwise
     */
    boolean offer(T element);

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element removed from the front of the queue
     */
    T remove();

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element removed from the front of the queue, or null if the queue is empty
     */
    T poll();

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     */
    T element();

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue, or null if the queue is empty
     */
    T peek();

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    int size();
}



