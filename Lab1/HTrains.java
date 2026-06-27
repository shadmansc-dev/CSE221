import java.io.*;
import java.util.*;

public class HTrains {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        String []arr=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=br.readLine();
        }
        String name[]=new String[n];
        String time[]=new String[n];
        for(int i=0;i<n;i++){
            String s[]=arr[i].split(" ");
            name[i]=s[0];
            time[i]=s[s.length-1];
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(name[j].compareTo(name[j+1])>0){
                    String temp=arr[j];
                    String temp1=name[j];
                    String temp2=time[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    name[j]=name[j+1];
                    name[j+1]=temp1;
                    time[j]=time[j+1];
                    time[j+1]=temp2;
                }
                else if(name[j].compareTo(name[j+1])==0){
                    if(time[j].compareTo(time[j+1])<0){
                        String temp=arr[j];
                        String temp1=name[j];
                        String temp2=time[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                        name[j]=name[j+1];
                        name[j+1]=temp1;
                        time[j]=time[j+1];
                        time[j+1]=temp2;
                    }
                    else if(time[j].compareTo(time[j+1])==0){
                        continue;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            pw.println(arr[i]);
        }

        pw.flush();
        pw.close();
    }
}