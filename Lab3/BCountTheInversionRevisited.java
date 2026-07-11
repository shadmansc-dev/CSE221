import java.io.*;
import java.util.*;

public class BCountTheInversionRevisited {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long[] sorted = arr.clone();
        Arrays.sort(sorted);

        int m = sorted.length;
        long[] bit = new long[m + 1];

        long count = 0;
        for (int j = 0; j < n; j++) {
            long threshold = arr[j] * arr[j];
            int pos = upperBound(sorted, threshold, m);
            count += getSum(bit, m) - getSum(bit, pos);
            int idx = Arrays.binarySearch(sorted, arr[j]);
            addOne(bit, idx + 1, m);
        }

        pw.println(count);
        pw.flush();
        pw.close();
    }

    static int upperBound(long[] sorted, long val, int m) {
        int lo = 0;
        int hi = m;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (sorted[mid] <= val) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    static void addOne(long[] bit, int i, int m) {
        while (i <= m) {
            bit[i]++;
            i += i & (-i);
        }
    }

    static long getSum(long[] bit, int i) {
        long sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & (-i);
        }
        return sum;
    }
}