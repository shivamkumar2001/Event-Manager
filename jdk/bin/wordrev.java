import java.io.*;
class wordrev
{
public static void main(String arg[])throws IOException
{
String str;
int i,j;
BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter String :");
str=bf.readLine();
str=""+str+"";
for(i=1;i<str.length();i++)
{
if(str.charAt(i)==' ')
{
for(j=i;str.charAt(j-1)!=' ';j--)
{
System.out.print(str.charAt(j-1));
}
System.out.print(" ");
}
}
}
}		