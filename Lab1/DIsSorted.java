import java.io.*;
import java.util.*;
/**
 * DIsSorted
 */
public class DIsSorted {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        while(t-->0){
            st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int arr[]=new int[n];
            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            boolean flag=true;
            for(int i=0;i<n-1;i++){
                if(arr[i]>arr[i+1]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                out.println("YES");
            }
            else{
                out.println("NO");
            }
        }
        out.flush();
        out.close();
    }
}
