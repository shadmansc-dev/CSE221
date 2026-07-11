import java.io.*;
import java.util.*;

public class DFastMatrixDrift {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        long MOD = 1000000007;
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            long X = Long.parseLong(br.readLine());

            long r00 = 1, r01 = 0, r10 = 0, r11 = 1;

            while (X > 0) {
                if (X % 2 == 1) {
                    long n00 = (r00 * a + r01 * c) % MOD;
                    long n01 = (r00 * b + r01 * d) % MOD;
                    long n10 = (r10 * a + r11 * c) % MOD;
                    long n11 = (r10 * b + r11 * d) % MOD;
                    r00 = n00; r01 = n01; r10 = n10; r11 = n11;
                }
                long na = (a * a + b * c) % MOD;
                long nb = (a * b + b * d) % MOD;
                long nc = (c * a + d * c) % MOD;
                long nd = (c * b + d * d) % MOD;
                a = na; b = nb; c = nc; d = nd;
                X /= 2;
            }

            pw.println(r00 + " " + r01);
            pw.println(r10 + " " + r11);
        }

        pw.flush();
        pw.close();
    }
}