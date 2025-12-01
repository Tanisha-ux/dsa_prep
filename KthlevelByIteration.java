import java.util.*;

public class KthlevelByIteration {
    static class Node {
        int data;
        Node left, right;
        Node(int data) { this.data = data; }
    }

    static class BinaryTree {
        static int idx = -1;
        public Node buildtree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) return null;
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildtree(nodes);
            newNode.right = buildtree(nodes);
            return newNode;
        }

        public void printNodesAtKthLevel(Node root, int K) {
            if (root == null) return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            int level = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node curr = q.remove();
                    if (level == K) {
                        System.out.print(curr.data + " ");
                    }
                    if (curr.left != null) q.add(curr.left);
                    if (curr.right != null) q.add(curr.right);
                }
                if (level == K) break;
                level++;
            }
        }
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildtree(nodes);

        int K = 2;
        System.out.println("Nodes at level " + K + ":");
        tree.printNodesAtKthLevel(root, K);
    }
}
