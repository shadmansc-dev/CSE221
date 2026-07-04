import java.io.*;
import java.util.*;

public class HCanYouCutTheRopes {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        long k=Long.parseLong(st.nextToken());
        long []a=new long[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        long max=0,validChecker=0;
        for(int i=0;i<n;i++){
            if(a[i]>max){
                max=a[i];
            }
            validChecker+=a[i];
        }
        long low=1,high=max,result=-1;
        while(low<=high){
            long mid=low+(high-low)/2,sum=0;
            for(int i=0;i<n;i++){
                sum+=a[i]/mid;
            }
            if(sum>=k){
                low=mid+1;
                result=mid;
            }
            else{
                high=mid-1;
            }
        }
        pw.print(result);
        
        pw.flush();
        pw.close();
    }
}