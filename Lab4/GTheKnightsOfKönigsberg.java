import java.io.*;
import java.util.*;

public class GTheKnightsOfKonigsberg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[n][m];

        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        boolean found = false;

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for(int d = 0; d < 8; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny]){
                    found = true;
                }
            }

            board[x][y] = true;
        }

        if(found){
            pw.println("YES");
        } else {
            pw.println("NO");
        }

        pw.flush();
        pw.close();
    }
}