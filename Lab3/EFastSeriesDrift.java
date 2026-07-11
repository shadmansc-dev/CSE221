import java.io.*;
import java.util.*;

public class EFastSeriesDrift {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            long m = Long.parseLong(st.nextToken());
            pw.println(sumGeo(a, n, m));
        }
        pw.flush();
        pw.close();
    }

    static long sumGeo(long a, long n, long m) {
        if (n == 1) {
            return a % m;
        }
        if (n % 2 == 0) {
            long half = sumGeo(a, n / 2, m);
            long aPow = powMod(a, n / 2, m);
            return (half * ((1 + aPow) % m)) % m;
        } else {
            long prev = sumGeo(a, n - 1, m);
            long aPow = powMod(a, n, m);
            return (prev + aPow) % m;
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