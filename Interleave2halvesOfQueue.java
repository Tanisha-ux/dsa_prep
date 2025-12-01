// import java.util.*;

// public class Interleave2halvesOfQueue {

//     public static void interleave(Queue<Integer> q) {
//         // ❗ Step 1: Check if queue size is even
//         if (q.size() % 2 != 0) {
//             System.out.println("Queue size must be even.");
//             return;
//         }

//         int halfSize = q.size() / 2;

//         // Step 2: Create first half queue
//         Queue<Integer> firstHalf = new LinkedList<>();
//         for (int i = 0; i < halfSize; i++) {
//             firstHalf.add(q.remove()); // moves first half into firstHalf queue
//         }

//         // Step 3: Interleave first half and second half
//         while (!firstHalf.isEmpty()) {
//             q.add(firstHalf.remove()); // take from first half
//             q.add(q.remove());         // take from second half (original queue still has it)
//         }
//     }

//     // Just to print queue in a line
//     public static void print(Queue<Integer> q) {
//         while (!q.isEmpty()) {
//             System.out.print(q.remove() + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String args[]) {
//         Queue<Integer> q = new LinkedList<>();

//         // filling queue with 1 to 10
//         for (int i = 1; i <= 10; i++) {
//             q.add(i);
//         }

//         interleave(q);  // Call the fixed function
//         print(q);       // Should print: 1 6 2 7 3 8 4 9 5 10
//     }
// }




import java.util.*;

public class Interleave2halvesOfQueue {
    public static void interleave(Queue<Integer>q){
        int halfqSize=q.size()/2;
        Queue<Integer> halfq=new LinkedList<>();
        
        
        if (q.size() % 2 != 0) {
            System.out.println("Queue size must be even.");
            return;
        }

        for(int i=0;i<halfqSize;i++){
            halfq.add(q.remove());
        }

        while(!halfq.isEmpty()){
            q.add(halfq.remove());
            q.add(q.remove());
        }
        

    }

    public static void print(Queue<Integer> q){
        while(!q.isEmpty()){
            System.out.println(q.remove());
        }
    }

    public static void main(String args[]){
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interleave(q);
        print(q);

    }
}
