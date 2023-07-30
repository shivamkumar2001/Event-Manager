import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
public class fundreport extends Frame implements ItemListener,ActionListener
{
JPanel pn= new JPanel();
JLabel lbhead = new JLabel("Fund Reports");
JRadioButton rbpa= new JRadioButton("Participants");
JRadioButton rbst = new JRadioButton("Staffs");
JRadioButton rbsp = new JRadioButton("Sponsers");
ButtonGroup bg= new ButtonGroup(); 
JLabel lbreg = new JLabel("Registration no.");
JComboBox cbev = new JComboBox();
JButton btp = new JButton(new ImageIcon("images/im/btns.jpg"));
JButton btst = new JButton(new ImageIcon("images/im/btns.jpg"));
JButton btsp = new JButton(new ImageIcon("images/im/btns.jpg"));  
//JButton btn = new JButton(new ImageIcon("images/im/btns.jpg"));
 JTextField txtreg = new JTextField();
 Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
 public fundreport()
 {
  setTitle("Fund Report");
  setLocation((int)(d1.getWidth()/2)-400,(int)(d1.getHeight()/2)-300);
  setLayout(null);
  setVisible(true);
  int x = (int)d1.getWidth();            
  int y = (int)d1.getHeight();            
  setResizable(false);
  setSize(800,600);
  setBackground(new Color(0,0,0));
  lbhead.setBounds(150,60,400,60);
  rbpa.setBounds(30,180,200,30);
  rbst.setBounds(260,180,200,35);
  rbsp.setBounds(490,180,200,35);
 
  lbreg.setBounds(150,280,200,90);
  txtreg.setBounds(400,300,100,40);
  cbev.setBounds(400,300,200,40);
  btp.setBounds(420,380,100,40);
  btsp.setBounds(420,400,100,40);
  btst.setBounds(420,400,100,40);
  
 
  Font f2 = new Font("Californian FB",Font.BOLD,20);
  Font f3=new Font("Berlin Sans FB",Font.BOLD,15);
  rbpa.setFont(f2);
  rbsp.setFont(f2);
  rbst.setFont(f2);
  cbev.setFont(f3);
  txtreg.setFont(f3);
  lbreg.setFont(f2);
   lbreg.setForeground(Color.WHITE);
  //txtrg.setEditable(false);
  //txt.setVisible(false);
  //btn.setVisible(false);
  Font f1 = new Font("Imprint MT Shadow",Font.BOLD,60);
  lbhead.setForeground(new Color(255,192,0));
  lbhead.setFont(f1);

  bg.add(rbpa);
  bg.add(rbst);
  bg.add(rbsp);
  add(lbreg);
  add(cbev);
  add(txtreg);
  add(btst);
  add(btsp);
  add(btp);
  add(rbpa);
  add(rbsp);
  add(rbst);
  add(lbhead);
  add(txtreg);
 

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


  
cbev.setVisible(false);
rbst.addItemListener(this);
rbpa.addItemListener(this);
rbsp.addItemListener(this);
txtreg.setVisible(false);
lbreg.setVisible(false);
btsp.setVisible(false);
btsp.addActionListener(this);
btst.setVisible(false);
btst.addActionListener(this);
btp.setVisible(false);
btp.addActionListener(this);


repaint(); 
}    

 public void itemStateChanged(ItemEvent ie)
 {
 if(rbpa.isSelected())
  {
	 
	 btp.setVisible(true);
	 btst.setVisible(false);
	 btsp.setVisible(false);
    txtreg.setVisible(true);
	lbreg.setVisible(true);
	cbev.setVisible(false);
	
  }

  if(rbst.isSelected())
  {
	txtreg.setVisible(false);
	cbev.setVisible(true);
	btst.setVisible(true);
	btsp.setVisible(false);
	btp.setVisible(false);
    lbreg.setVisible(true);
	 
  }
  if(rbsp.isSelected())
  {
	txtreg.setVisible(false);
	cbev.setVisible(true);
	btsp.setVisible(true);
	btst.setVisible(false);
	btp.setVisible(false);
    lbreg.setVisible(true);
	 
  }
 }
public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==btp)
	{
		int flag=0;
		try 
		{
	            Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
   			    Statement st=con1.createStatement();
				ResultSet res1=st.executeQuery("Select * from fundcolltbl where registrationno='"+txtreg.getText()+"'");
				PrintWriter pw=new PrintWriter("registrationnoreport.txt");
				pw.println("Student Details assigned to...");
				pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				pw.println(" Receiptno      Registrationno.          sName              PaidDate          Amount");
				pw.println("-------------------------------------------------------------------------------------------------------------------------------------");
				while(res1.next())
				{
					flag=1;
					pw.printf("%-20s",res1.getString(1));
				    pw.printf("%-20s",res1.getString(2));
					pw.printf("%-20s",res1.getString(3));
					pw.printf("%-20s",res1.getString(4));
					pw.printf("%-20s",res1.getString(5));
					pw.printf("\n");
				}
				pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				pw.close();
				Runtime rt=Runtime.getRuntime();
				if(flag==1)
				{
				rt.exec("notepad.exe registrationnoreport.txt");
				}
				else
				{
				     JOptionPane.showMessageDialog(null,"Student does not exist");
				}
				con1.close();
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
	}
	if(ae.getSource()==btst)
	{
		
		try 
		{
	            Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
   			    Statement st=con1.createStatement();
				ResultSet res1=st.executeQuery("Select * from fundcolltbl2 where eventtype='"+cbev.getSelectedItem()+"'");
				PrintWriter pw=new PrintWriter("eventtypereport.txt");
				pw.println("Event type "+cbev.getSelectedItem()+" assigned to...");
				pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				pw.println("Receipt no.     Registration no.           Name           Paid Date           Amount             EventType");
				pw.println("-----------------------------------------------------------------------~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				while(res1.next())
				{
					pw.printf("%-20s",res1.getString(1));
				    pw.printf("%-20s",res1.getString(2));
					pw.printf("%-20s",res1.getString(3));
					pw.printf("%-18s",res1.getString(4));
					pw.printf("%-20s",res1.getString(5));
					pw.printf("%-20s",res1.getString(6));
					pw.printf("\n");
				}
				pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				pw.close();
				Runtime rt=Runtime.getRuntime();
				rt.exec("notepad.exe eventtypereport.txt");
				con1.close();
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
	}
	if(ae.getSource()==btsp)
	{
		try 
		{
	            Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
   			    Statement st=con1.createStatement();
				ResultSet res1=st.executeQuery("Select * from fundcolltbl2 where eventtype='"+cbev.getSelectedItem()+"'");
				PrintWriter pw=new PrintWriter("eventtypereport.txt");
				pw.println("Event type "+cbev.getSelectedItem()+" assigned to...");
				pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				pw.println("Receipt no.    Registration no.        Name        Paid Date          Amount       EventType");
				pw.println("----------------------------------------------------------------------------------------------------");
				while(res1.next())
				{
					
					pw.printf("%-15s",res1.getString(1));
				    pw.printf("%-20s",res1.getString(2));
					pw.printf("%-20s",res1.getString(3));
					pw.printf("%-18s",res1.getString(4));
					pw.printf("%-20s",res1.getString(5));
					pw.printf("%-15s",res1.getString(6));
					pw.printf("\n");
				}
				pw.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				pw.close();
				Runtime rt=Runtime.getRuntime();
				rt.exec("notepad.exe eventtypereport.txt");
				con1.close();
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}
	}
}
 public static void main(String args[])
 {
 fundreport fr = new fundreport();
 }
}