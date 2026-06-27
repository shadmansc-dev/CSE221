import java.io.*;
import java.util.*;

public class EReverseSorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        long arr[]=new long[n];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        long count=0;
        boolean s=true;
        ArrayList<Long>b=new ArrayList<>();
        while(s){
            s=false;
            for(int i=0;i<n-2;i++){
                if(arr[i]>arr[i+2]){
                    count++;
                    long temp=arr[i];
                    arr[i]=arr[i+2];
                    arr[i+2]=temp;
                    b.add((long)i+1);
                    s=true;
                }
            } 
        }
        boolean isSorted=true;
        for(int i=0;i<n-1;i++){
            if (arr[i]>arr[i+1]) {
                isSorted=false;
            }
        }
        if(isSorted){
            pw.println("YES");
            pw.println(count);
            for(int i=0;i<b.size();i++){
                pw.println(b.get(i)+" "+(b.get(i)+2));
            }
        }
        else{
            pw.println("NO");
        }
        pw.flush();
        pw.close();
    }
}