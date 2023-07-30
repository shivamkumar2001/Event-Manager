import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.applet.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
public class Assignment extends JFrame implements ActionListener,FocusListener,ItemListener
{
int rowcount=0;
JLabel lbhd = new JLabel("EVENT ASSIGNMENT");
JLabel lbevid = new JLabel("EVENT ID");
JLabel lbevty = new JLabel("EVENT TYPE");
JLabel lbevna = new JLabel("EVENT NAME");
JLabel lbreg = new JLabel("ENTER REGISTRATION NUMBER");
JLabel lbsna = new JLabel("STUDENT NAME");
JTextField txtevid = new JTextField();
JTextField txtevty = new JTextField();
JTextField txtreg = new JTextField();
JTextField txtsna = new JTextField();
JComboBox cbevna = new JComboBox();
JButton btnad = new JButton("ADD");
JButton btnre = new JButton("REMOVE");
JButton btnsv = new JButton("SAVE");
JButton btncn = new JButton("CANCEL");
     String[] col = {"REGISTRATION NO","STUDENT NAME","EVENT TYPE","EVENT NAME"};
     String reg,stna,evty,evna;
Object [] []data ={{reg},{stna},{evty},{evna}};
DefaultTableModel model = new DefaultTableModel(col,0);
JTable tblen = new JTable(data,col);
JScrollPane spanel = new JScrollPane(tblen);
Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
public Assignment ()
     {
      setLayout(null);
      setVisible(true);
      int x = (int)d1.getWidth();
      int y = (int)d1.getHeight();
      setResizable(false);
      setSize(1000,1000); 
      lbhd.setBounds(390,40,500,40);
 lbevid.setBounds(20,150,100,20);
 txtevid.setBounds(200,150,70,40);
 lbevty.setBounds(20,210,140,20);
 txtevty.setBounds(200,210,120,40);
 lbevna.setBounds(20,270,140,20);
 cbevna.setBounds(200,270,150,40);
 tblen.setModel(model);
 spanel.setBounds(400,260,450,300);
 add (spanel);
 lbreg.setBounds(20,400,300,20);
 txtreg.setBounds(20,440,100,40);
 lbsna.setBounds(20,500,200,20);
 txtsna.setBounds(20,540,220,40);
 btnad.setBounds(870,440,100,40);
 btnre.setBounds(870,490,120,40);
 btnsv.setBounds(430,600,100,40);
 btncn.setBounds(780,600,120,40);
 Font f1 = new Font("Imprint MT Shadow",Font.BOLD,35);
 Font f2 = new Font("Californian FB",Font.BOLD,18);
 Font f3 = new Font("Berlin Sans FB",Font.PLAIN,16);
 lbhd.setForeground(new Color(100,0,60));
      lbhd.setFont(f1);
 lbevid.setFont(f2);
      lbevty.setFont(f2);
      lbevna.setFont(f2);
 lbreg.setFont(f2);
 lbsna.setFont(f2);
      btnad.setFont(f2);
 btnre.setFont(f2);
 btnsv.setFont(f2);
 btncn.setFont(f2); 
 txtevid.setFont(f3);
 txtevty.setFont(f3);
 txtreg.setFont(f3);
 txtsna.setFont(f3);
 cbevna.setFont(f3);
 txtsna.setEditable(false);
 btnad.setBackground(new Color(100,0,50));
 btnre.setBackground(new Color(100,0,50));
 btnsv.setBackground(new Color(100,0,50));
 btncn.setBackground(new Color(100,0,50));
 btnad.setForeground(new Color(200,250,150));
 btnre.setForeground(new Color(200,250,150));
 btnsv.setForeground(new Color(200,250,150));
 btncn.setForeground(new Color(200,250,150));
 add (lbevid);
 add (lbevna);
 add (lbevty);
 add (lbhd);
 add (txtevid);
 add (txtevty);
 add (cbevna);
 add (btnad);
 add (btncn);
 add (btnsv);
 add (btnre);
 add (lbreg);
 add (lbsna);
 add (txtreg);
 add (txtsna);
 btnad.addActionListener(this);
 btncn.addActionListener(this);
 btnsv.addActionListener(this);
 btnre.addActionListener(this);
 txtevid.addFocusListener(this);
 txtreg.addFocusListener(this);
 cbevna.addItemListener(this);
 repaint();
}
public void itemStateChanged(ItemEvent ie)
{
try
{
    Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
    Statement st = con.createStatement();
String str="Select * from assignmenttbl where eventtype='"+txtevty.getText()+"' and eventname='"+cbevna.getSelectedItem()+"'";
    ResultSet res = st.executeQuery(str);
model.setRowCount(0);
    while(res.next())
   {
                     Vector v = new Vector();
                     v.add(res.getString(1));
                     v.add(res.getString(2));
                     v.add(txtevty.getText());
                     v.add(cbevna.getSelectedItem());
model.addRow(v);
}
rowcount=model.getRowCount();
con.close();
}
catch(Exception iee)
{
System.out.println(iee);
}
}
public void focusLost(FocusEvent fe)
{   
    if(fe.getSource()==txtevid)
{   
             txtevty.setText("");
             cbevna.addItem("--SELECT--"); 
        try
        {
cbevna.removeAllItems();
        cbevna.addItem("--SELECT--");
    Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
    Statement st = con.createStatement();
    String str="Select * from calendar where eventid='"+txtevid.getText()+"'";
    ResultSet res = st.executeQuery(str);
    while(res.next())
   {
    txtevty.setText(res.getString(2));
    String temp[]=res.getString(4).split(",");
    for(int j=0;j<temp.length;j++)
        cbevna.addItem(temp[j]);
   }
   con.close();

}
catch(Exception ee)
{
System.out.println(ee);
}
}
    if(fe.getSource()==txtreg)
{   txtsna.setText("");
try
{
Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
    Statement st = con.createStatement();
    String str="Select * from studenttbl where registrationno='"+txtreg.getText()+"'";
    ResultSet res = st.executeQuery(str);
while(res.next())
{
txtsna.setText(res.getString(2));
  }
  con.close();
}
catch(Exception ee)
{
System.out.println(ee);
}
}
}
public void focusGained(FocusEvent fe)
{

}
 public void actionPerformed (ActionEvent e) 
 {

 if (e.getSource() == btnad)
 { 
       int flg=0; 

       for(int i=0;i<model.getRowCount();i++)
{
if(txtreg.getText().equals(model.getValueAt(i,0)))
{
JOptionPane.showMessageDialog(null,"Student already registered");
flg=1;
break;
} 
}
  if(flg==0)
   {
  Vector v=new Vector();
  v.add(txtreg.getText());
  v.add(txtsna.getText());
  v.add(txtevty.getText());
  v.add(cbevna.getSelectedItem());
  model.addRow(v);  
  }
  }
 if (e.getSource() == btnre)
 {
 
             model.removeRow(tblen.getSelectedRow());
 }
 if (e.getSource() == btnsv)
 {    
System.out.println("11111111111111");
  if(txtevty.getText().length()!=0&&txtsna.getText().length()!=0&&txtevid.getText().length()!=0&&txtreg.getText().length()!=0)
  {
 try
              {   
    Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
	Statement myst=con1.createStatement();
	myst.executeUpdate("delete from assignmenttbl where eventtype='"+txtevty.getText()+"' and eventname='"+cbevna.getSelectedItem()+"'");
    Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
    String str = "insert into assignmenttbl(REGNO,STUDENTNAME,EVENTTYPE,EVENTNAME,PAIDSTATUS)values(?,?,?,?,?)";
		for(int i=0;i<model.getRowCount();i++)
         {
          PreparedStatement ps = con.prepareStatement(str);
		  ps.setString(1,""+model.getValueAt(i,0));
		  ps.setString(2,""+model.getValueAt(i,1)); 
		  ps.setString(3,""+model.getValueAt(i,2));
		  ps.setString(4,""+model.getValueAt(i,3));
		  ps.setString(5,"N/A");
		  ps.executeUpdate();
         }
Statement st = con.createStatement();
JOptionPane.showMessageDialog(null,"Saved");
txtsna.setText("");
con1.close();
     }
 catch(Exception ee)
 {
 System.out.println(ee);
 }
 }
  else
  JOptionPane.showMessageDialog(null,"Empty Field Cannot be Saved");
 } 

 if (e.getSource() == btncn)
 {
 this.dispose();
 }
 }
 public static void main (String args[])
 {
 Assignment as = new Assignment();
 }
}
