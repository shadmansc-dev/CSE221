import java.io.*;
import java.util.*;

public class ELongestKDistinctSubarray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int [] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Map<Integer,Integer>map=new HashMap<>();
        int l=0,r=0,max=0;
        while(r<n){
            map.put(arr[r],map.getOrDefault(arr[r],0)+1);
            while (map.size()>k) {
                map.put(arr[l],map.get(arr[l])-1);
                if(map.get(arr[l])==0){
                    map.remove(arr[l]);
                }
                l++;
            }
            max=Math.max(max, r-l+1);
            r++;
        }
        pw.print(max);
        pw.flush();
        pw.close();
    }
}