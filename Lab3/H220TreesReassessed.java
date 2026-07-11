import java.io.*;
import java.util.*;

public class H220TreesReassessed {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] postorder = new int[n];
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        int[] preorder = new int[n];
        solve(inorder, 0, n - 1, postorder, 0, n - 1, preorder, 0);

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                pw.print(" ");
            }
            pw.print(preorder[i]);
        }
        pw.flush();
        pw.close();
    }

    public static int solve(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2, int[] preorder, int idx) {
        if (l1 > r1) {
            return idx;
        }

        int root = postorder[r2];

        int splitIndex = l1;
        for (int i = l1; i <= r1; i++) {
            if (inorder[i] == root) {
                splitIndex = i;
            }
        }

        int leftSize = splitIndex - l1;

        preorder[idx] = root;
        idx++;

        idx = solve(inorder, l1, splitIndex - 1, postorder, l2, l2 + leftSize - 1, preorder, idx);
        idx = solve(inorder, splitIndex + 1, r1, postorder, l2 + leftSize, r2 - 1, preorder, idx);

        return idx;
    }
}