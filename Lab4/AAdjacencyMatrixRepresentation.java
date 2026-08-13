import java.io.*;
import java.util.*;

public class AAdjacencyMatrixRepresentation {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] adjM = new int[n][n];

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken())-1;
            int v=Integer.parseInt(st.nextToken())-1;
            int w=Integer.parseInt(st.nextToken());
            adjM[u][v]=w;
        }

        for(int i=0;i<n;i++){
            for (int j= 0;j<n;j++){
                pw.print(adjM[i][j]);
                if (j<n-1){
                    pw.print(" ");
                }
            }
            pw.println();
        }

        pw.flush();
        pw.close();
    }
}