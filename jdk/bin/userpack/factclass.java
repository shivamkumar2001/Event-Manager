package userpack;
import java.io.*;
public class  factclass
{
      public void fact()throws IOException
      {
             int i,n,f=1;
             InputStreamReader in=new InputStreamReader(System.in);
             BufferedReader  br=new BufferedReader(in);
             System.out.print("Enter number:");
               n=Integer.parseInt(br.readLine());
             for(i=1;i<=n;i++)
              {
              	f=f*i;
              }  
  System.out.print("Factorial is="+f);
      }
//public static void main(String argv[])T
}