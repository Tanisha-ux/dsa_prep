import java.util.*;

public class FloodFillAlgorithm {
    public static void helper(int sr, int sc, int[][] image, boolean[][] vis, int orgCol, int color) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        if (vis[sr][sc] || image[sr][sc] != orgCol) return;

        // Mark visited and update color
        vis[sr][sc] = true;
        image[sr][sc] = color;

        // Recurse in 4 directions
        helper(sr + 1, sc, image, vis, orgCol, color);
        helper(sr - 1, sc, image, vis, orgCol, color);
        helper(sr, sc + 1, image, vis, orgCol, color);
        helper(sr, sc - 1, image, vis, orgCol, color);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] vis = new boolean[image.length][image[0].length];
        helper(sr, sc, image, vis, image[sr][sc], color);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1, sc = 1, color = 2;

        FloodFillAlgorithm ffa = new FloodFillAlgorithm();
        int[][] result = ffa.floodFill(image, sr, sc, color);

        System.out.println("Flood-filled image:");
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
