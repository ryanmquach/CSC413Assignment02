import java.util.LinkedList;
import java.util.PriorityQueue;

public class LListPriorityQueue implements QueueInterface<User> {
    private LinkedList<User> userList;
    private PriorityQueue<User> priorityQueue;

    public LListPriorityQueue() {
        userList = new LinkedList<>();
        priorityQueue = new PriorityQueue<>();
    }

    @Override
    public void add(User user) {
        userList.add(user);
        priorityQueue.add(user);
    }

    @Override
    public boolean offer(User user) {
        userList.add(user);
        return priorityQueue.offer(user);
    }

    @Override
    public User remove() {
        userList.remove();
        return priorityQueue.remove();
    }

    @Override
    public User poll() {
        userList.poll();
        return priorityQueue.poll();
    }

    @Override
    public User element() {
        return priorityQueue.element();
    }

    @Override
    public User peek() {
        return priorityQueue.peek();
    }

    @Override
    public int size() {
        return priorityQueue.size();
    }
}