import java.io.*;
import java.util.*;

public class EFastSeriesDrift {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            pw.println(sumGeo(a, n, m)[0]);
        }
        pw.flush();
        pw.close();
    }

    static long[] sumGeo(long a, long n, long m) {
        if (n == 1) {
            long amod = a % m;
            return new long[]{amod, amod};
        }
        if (n % 2 == 0) {
            long[] half = sumGeo(a, n / 2, m);
            long halfSum = half[0];
            long halfPow = half[1];
            long totalSum = (halfSum * ((1 + halfPow) % m)) % m;
            long totalPow = (halfPow * halfPow) % m;
            return new long[]{totalSum, totalPow};
        } else {
            long[] prev = sumGeo(a, n - 1, m);
            long prevSum = prev[0];
            long prevPow = prev[1];
            long curPow = (prevPow * (a % m)) % m;
            long totalSum = (prevSum + curPow) % m;
            return new long[]{totalSum, curPow};
        }
    }

    static long powMod(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return result;
    }
}