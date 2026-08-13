import java.io.*;
import java.util.*;

public class CGraphMetamorphosis {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j = 0; j < k; j++){
                int neighbor = Integer.parseInt(st.nextToken());
                matrix[i][neighbor] = 1;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                pw.print(matrix[i][j] + " ");
            }    
            pw.println();
        }

        pw.flush();
        pw.close();
    }
}