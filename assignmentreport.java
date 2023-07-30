import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
public class assignmentreport extends JFrame implements ItemListener,ActionListener
{
 JLabel lbhead = new JLabel("Reports");
 JRadioButton rbst= new JRadioButton("Student Wise");
 JRadioButton rbev = new JRadioButton("Event Wise");
 ButtonGroup bg= new ButtonGroup(); 
 JLabel strg = new JLabel("Student Registration no.");
 JTextField txtst = new JTextField();
 JButton bts = new JButton("OK");                                                                  
 JLabel evty = new JLabel("Event Type");
 JComboBox cbev = new JComboBox();
 JButton bte = new JButton("OK");
 Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
 
 
 public assignmentreport()
 {
  setLayout(null);
  setVisible(true);
  int x = (int)d1.getWidth();
  int y = (int)d1.getHeight();
  setResizable(false);
  setSize(x,y);
  lbhead.setBounds(800,20,200,40);
  rbst.setBounds(450,80,200,20);
  rbev.setBounds(850,80,250,20);
 
  strg.setBounds(50,120,150,60);
  txtst.setBounds(350,120,150,40);
  bts.setBounds(450,180,100,40);
  
  evty.setBounds(750,150,100,20);
  cbev.setBounds(850,150,100,20);
  bte.setBounds(850,180,100,40);
 
  Font f2 = new Font("Arial",Font.BOLD,25);
  rbev.setFont(f2);
  rbst.setFont(f2);
  

  //txtrg.setEditable(false);
  //txt.setVisible(false);
  //btn.setVisible(false);
  Font f1 = new Font("Monotype Corsiva",Font.BOLD,30);
  lbhead.setForeground(new Color(100,0,60));
  lbhead.setFont(f1);

  
  //btsave.setEnabled(false);
  //btedit.setEnabled(false);
  bg.add(rbev);
  bg.add(rbst);
  add(bts);
  add(bte);
  add(rbev);
  add(rbst);
  add(lbhead);
  add(cbev);
  add(txtst);
  add(strg);
  add(evty);

 /* add(lbgn);
  add(lbdb);
  add(txtdob);
  add(lbbch);
  add(txtbch);
  add(lbdp);
  add(lbemail);
  add(txtemail);
  add(lbphn);
  add(txtphn);
  add(lbad);
  add(txtadd);


  add(btnew);
  add(btsave);
  add(btser);
  add(btedit);
  add(btcan);
  add(btn);
  add(txt);*/

        try 
		{
	            Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
   			    Statement st=con1.createStatement();
				ResultSet res1=st.executeQuery("Select distinct eventtype from Calendar");
			    while(res1.next())
				{
					cbev.addItem(res1.getString(1));
				}
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
 

  
rbev.addItemListener(this);
rbst.addItemListener(this);
strg.setVisible(false);
txtst.setVisible(false);
evty.setVisible(false);
cbev.setVisible(false);
bte.setVisible(false);
bts.setVisible(false);
bte.addActionListener(this);
bts.addActionListener(this);

  
 /*comdpart.addItemListener(this);
  btn.addActionListener(this);
  btnew.addActionListener(this);
  btsave.addActionListener(this);
  btser.addActionListener(this);
  btedit.addActionListener(this);
  btcan.addActionListener(this);*/

repaint(); 
}    

 public void itemStateChanged(ItemEvent ie)
 {
 if(rbst.isSelected())
  {
	  evty.setVisible(false);
	 cbev.setVisible(false);
	 bte.setVisible(false);
    strg.setVisible(true);
	txtst.setVisible(true);
	bts.setVisible(true);
  }

  if(rbev.isSelected())
  {
	  strg.setVisible(false);
	txtst.setVisible(false);
	bts.setVisible(false);
     evty.setVisible(true);
	 cbev.setVisible(true);
	 bte.setVisible(true);
  }
 }
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==bts)
	{
		try 
		{
	            Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
   			    Statement st=con1.createStatement();
				ResultSet res1=st.executeQuery("Select * from studenttbl where registrationno='"+txtst.getText()+"'");
				PrintWriter pw=new PrintWriter("registrationnoreport.txt");
				pw.println("Student Details assigned to...");
				pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				pw.println("Registrationno.   sName        Gender      Date of Birth     Department        Batch      Email id        phn no.         Address");
				pw.println("-------------------------------------------------------------------------------------------------------------------------------------");
				while(res1.next())
				{
					pw.printf("%-20s",res1.getString(1));
				    pw.printf("%-20s",res1.getString(2));
					pw.printf("%-20s",res1.getString(3));
					pw.printf("%-20s",res1.getString(4));
					pw.printf("%-20s",res1.getString(5));
					pw.printf("%-20s",res1.getString(6));
					pw.printf("%-20s",res1.getString(7));
					pw.printf("%-20s",res1.getString(8));
					pw.printf("%-20s",res1.getString(9));
					pw.printf("\n");
				}
				pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				pw.close();
				Runtime rt=Runtime.getRuntime();
				rt.exec("notepad.exe registrationnoreport.txt");
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
	}
	if(ae.getSource()==bte)
	{
		try 
		{
	            Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
   			    Statement st=con1.createStatement();
				ResultSet res1=st.executeQuery("Select * from assignmenttbl where eventtype='"+cbev.getSelectedItem()+"'");
				PrintWriter pw=new PrintWriter("eventtypereport.txt");
				pw.println("Event type "+cbev.getSelectedItem()+" assigned to...");
				pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				pw.println("Reg no.   Student name        Event name      Paid Status");
				pw.println("-----------------------------------------------------------------------");
				while(res1.next())
				{
					pw.printf("%-10s",res1.getString(1));
				    pw.printf("%-20s",res1.getString(2));
					pw.printf("%-18s",res1.getString(4));
					pw.printf("%-5s",res1.getString(5));
					pw.printf("\n");
				}
				pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				pw.close();
				Runtime rt=Runtime.getRuntime();
				rt.exec("notepad.exe eventtypereport.txt");
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
	}
}
   
 public static void main(String args[])
 {
 assignmentreport sp = new assignmentreport();
 }
}