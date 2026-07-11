import java.io.*;
import java.util.*;

public class G220Trees {
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
        int[] preorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = Integer.parseInt(st.nextToken());
        }

        int[] postorder = new int[n];
        solve(inorder, 0, n - 1, preorder, 0, n - 1, postorder, 0);

        for (int i = 0; i < n; i++) {
            pw.print(postorder[i]+" ");
        }
        pw.flush();
        pw.close();
    }

    public static int solve(int[] inorder, int l1, int r1, int[] preorder, int l2, int r2, int[] postorder, int idx) {
        if (l1 > r1) {
            return idx;
        }

        int root = preorder[l2];

        int splitIndex = l1;
        for (int i = l1; i <= r1; i++) {
            if (inorder[i] == root) {
                splitIndex = i;
            }
        }

        int leftSize = splitIndex - l1;

        idx = solve(inorder, l1, splitIndex - 1, preorder, l2 + 1, l2 + leftSize, postorder, idx);
        idx = solve(inorder, splitIndex + 1, r1, preorder, l2 + leftSize + 1, r2, postorder, idx);

        postorder[idx] = root;
        idx++;

        return idx;
    }
}