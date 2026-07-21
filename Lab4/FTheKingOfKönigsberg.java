import java.io.*;
import java.util.*;

public class FTheKingOfKonigsberg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        List<int[]> moves = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n){
                moves.add(new int[]{nx + 1, ny + 1});
            }
        }

        moves.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        pw.println(moves.size());
        for(int i = 0; i < moves.size(); i++){
            pw.println(moves.get(i)[0] + " " + moves.get(i)[1]);
        }

        pw.flush();
        pw.close();
    }
}