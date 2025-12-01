import java.util.*;

public class InterleaveQueueoddeven {

    public static void interleave(Queue<Integer> q) {
        int totalSize = q.size();
        int halfSize = totalSize / 2;

        Queue<Integer> firstHalf = new LinkedList<>();
        for (int i = 0; i < halfSize; i++) {
            firstHalf.add(q.remove());
        }

        Queue<Integer> secondHalf = q; // Remaining elements in q are second half (possibly longer)

        // New queue to hold interleaved result
        Queue<Integer> result = new LinkedList<>();

        while (!firstHalf.isEmpty() || !secondHalf.isEmpty()) {
            if (!firstHalf.isEmpty()) {
                result.add(firstHalf.remove());
            }
            if (!secondHalf.isEmpty()) {
                result.add(secondHalf.remove());
            }
        }

        // Copy result back to original queue
        while (!result.isEmpty()) {
            q.add(result.remove());
        }
    }

    public static void print(Queue<Integer> q) {
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Test with even size
        System.out.println("Even size:");
        for (int i = 1; i <= 10; i++) {
            q.add(i);
        }
        interleave(q);
        print(q); // Output: 1 6 2 7 3 8 4 9 5 10

        // Test with odd size
        System.out.println("Odd size:");
        for (int i = 1; i <= 9; i++) {
            q.add(i);
        }
        interleave(q);
        print(q); // Output: 1 6 2 7 3 8 4 9 5
    }
}

