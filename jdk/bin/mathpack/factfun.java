import java.io.*;
Pakckage mathpack.*;
public class mathclass
{
int i,f=1;
public static void factfun(int num)throws IOException
 {
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 System.out.println("Enter the number:");
 num=Integer.parseInt(br.readLine());
         for(i=1;i<=num;i++)
		 {
		 f=f*i;
         }
	System.out.println(f);
 
 }
}