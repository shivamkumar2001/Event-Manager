package spack;
import java.io.*;
public class fact
{
        public void cal(int x)throws IOException
        {
	int f=1;
	for(int i=1;i<=x;i++)
	{
	      f=f*i;
	}
                 System.out.println("Factorial="+f);
         }
}