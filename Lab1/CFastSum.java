import java.io.*;
public class CFastSum{
    public static void main (String [] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T=Integer.parseInt(br.readLine());
        while(T-->0){
            long N=Integer.parseInt(br.readLine());
            out.println((N*(N+1))/2);
        }
        out.flush();
    }
}