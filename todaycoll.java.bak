import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
public class todaycoll extends Frame implements ActionListener
{
JLabel lbhead = new JLabel("Today's Collection");
JLabel lbdate = new JLabel("Today's Date");
JTextField txtdate = new JTextField();
JButton btda = new JButton(new ImageIcon("images/im/btns.jpg"));                                                                 
Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
public todaycoll()
{
  setLayout(null);
  setVisible(true);
  setTitle("Today's Collection");
    setLocation((int)(d1.getWidth()/2)-300,(int)(d1.getHeight()/2)-250);
  int x = (int)d1.getWidth();
  int y = (int)d1.getHeight();
  setResizable(false);
  setSize(600,500);
  setBackground(new Color(0,0,0));
  lbhead.setBounds(150,50,450,60);
  lbdate.setBounds(140,200,130,30);
  txtdate.setBounds(340,200,150,30);
  btda.setBounds(250,300,150,50);
  Font f1 = new Font("Imprint MT Shadow",Font.BOLD,36);
  lbhead.setForeground(new Color(255,192,0));
  lbhead.setFont(f1);
  Font f2 = new Font("Californian FB",Font.BOLD,20);
  Font f3 = new Font("Berlin Sans FB",Font.PLAIN,18);
  lbdate.setFont(f2);
  txtdate.setFont(f3);
  btda.setFont(f2);
  btda.setBackground(new Color(100,0,50));
  btda.setForeground(new Color(200,250,150));
  lbdate.setForeground(Color.WHITE);
  add(lbdate);
  add(lbhead);
  add(txtdate);
  add(btda);
  btda.addActionListener(this);
  repaint();
  }   
   public void actionPerformed(ActionEvent ae)
    {
          if(ae.getSource()==btda)
 {
 try
            {
                 Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
                 Statement st=con1.createStatement();
                 ResultSet res1=st.executeQuery("Select * from fundcolltbl where paiddate='"+txtdate.getText()+"'");
				   System.out.println(res1);
Connection con2 = DriverManager.getConnection("jdbc:odbc:eventdsn");
                 Statement s1=con2.createStatement();
ResultSet res2=s1.executeQuery("Select * from fundcolltbl2 where paiddate='"+txtdate.getText()+"' and left(registrationno,1)='t'");
Connection con3 = DriverManager.getConnection("jdbc:odbc:eventdsn");
                 Statement s2=con3.createStatement();
				 //System.out.println(s2);
ResultSet res3=s2.executeQuery("Select * from fundcolltbl2 where paiddate='"+txtdate.getText()+"' and left(registrationno,1)='s'");
                 PrintWriter pw=new PrintWriter("paydatereport.txt");
                 pw.println("Today's Date :- "+txtdate.getText()+ " and Collection.....");
pw.println("For Student :- ");
                 pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                 pw.println("Reg no        Name          Amount          Total");
                 pw.println("-----------------------------------------------------------------------");
double s=0.0,x=0.0;
                while(res1.next())
                {
x=Double.parseDouble(res1.getString(5));
                    pw.printf("%-10s",res1.getString(2));
                    pw.printf("%-20s",res1.getString(3));
                    pw.printf("%-18s",x);
                    pw.printf("\n");
s=s+x;
                }
pw.printf("%50s",s);
pw.println();
pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
pw.println();
                //teachers total collection
                 pw.println("Today's Date :- "+txtdate.getText()+"and Collection.....");
pw.println("For  Teachers:- ");
                 pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                 pw.println("Reg no        Name          Amount          Total");
                 pw.println("-----------------------------------------------------------------------");
s=0.0;x=0.0;
while(res2.next())
{
x=Double.parseDouble(res2.getString(5));
                pw.printf("%-10s",res2.getString(2));
                     pw.printf("%-20s",res2.getString(3));
                     pw.printf("%-18s",x);
                     pw.printf("\n");
s=s+x;
}
pw.printf("%50s",s);
pw.println();
                pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
pw.println();
//Sponsers total collection
                 
pw.println("Today's Date :- "+txtdate.getText()+"and Collection.....");
pw.println("For  Sponsers:- ");
                 pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                 pw.println("Reg no        Name          Amount          Total");
                 pw.println("-----------------------------------------------------------------------");
s=0.0;x=0.0;
while(res3.next())
{
x=Double.parseDouble(res3.getString(5));
                pw.printf("%-10s",res3.getString(2));
                     pw.printf("%-20s",res3.getString(3));
                     pw.printf("%-18s",x);
                     pw.printf("\n");
s=s+x;
}
pw.printf("%50s",s);
pw.println();
                pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
pw.println();

                pw.close();
                Runtime rt=Runtime.getRuntime();
                rt.exec("notepad.exe paydatereport.txt");
con1.close(); 
con2.close();
            }
            catch(Exception e)
            {
                  System.out.println(e);
            }
         }
  
}
   public static void main(String args[])
   {
         todaycoll sp = new todaycoll();
   }
}
