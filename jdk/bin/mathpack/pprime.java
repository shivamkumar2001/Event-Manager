package mathpack;
public class pprime
 {
          public void prime(int n)
            {
	   int i,ctr=0;
                   for(i=1;i<=n;i++)
	   {
		if(n%i==0)
		{
		     ctr++;
		}
	   }
                   if (ctr==2)
                            System.out.println("prime number");
                   else
                            System.out.println("not prime number");  
            }
 }