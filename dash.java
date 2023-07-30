import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.applet.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class dash extends JFrame implements ActionListener,MouseListener,MouseMotionListener,ItemListener
{	
JLabel lblimg = new JLabel(new ImageIcon("images/back2.jpg"));
JLabel lbllogo = new JLabel(new ImageIcon("images/im/logo.jpg"));
JPanel pnl = new JPanel();
JButton btn = new JButton();
JButton btntea = new JButton(new ImageIcon("images/teacher.jpg"));;
JButton btnsp = new JButton(new ImageIcon("images/sponser.jpg"));
JButton btnfund = new JButton(new ImageIcon("images/fund.jpg"));
JButton btnstu = new JButton(new ImageIcon("images/student1.jpg"));
JMenuBar mb = new JMenuBar();
JMenu mnmast = new JMenu("MASTER");
JMenu mntran = new JMenu("TRANSACTION");
JMenu mnre = new JMenu("REPORT");
JMenu mnex = new JMenu("CANCEL");
JComboBox cbev = new JComboBox();
JButton btnevcal = new JButton("Event Calender");
JButton btntocoll = new JButton("Today Collection");
JButton btntoexp = new JButton("Today Expense");

JMenuItem mnmaststu = new JMenuItem("STUDENT",new ImageIcon("images/student.png"));
JMenuItem mnmastspo = new JMenuItem("SPONSER",new ImageIcon("images/sponser.png"));
JMenuItem mnmastven = new JMenuItem("VENUE" , new ImageIcon("images/venue.png"));
JMenuItem mnmasteve = new JMenuItem("EVENT CALENDER",new ImageIcon("images/calendar.png"));
JMenuItem mnmateach = new JMenuItem("TEACHER");
JMenuItem mntranass = new JMenuItem("ASSIGNMENT",new ImageIcon("images/assign.png"));
JMenuItem mntranfund = new JMenuItem("FUND COLLECTION",new ImageIcon("images/fundcollection.png"));
JMenuItem mntranspass = new JMenuItem("SPONSER ASSIGNMENT");
JMenuItem mntranexp = new JMenuItem("EXPENSES");
JMenuItem mnreassreport = new JMenuItem("ASSIGNMENT REPORT");
JMenuItem mnrefundreport = new JMenuItem("FUND REPORT");
JMenuItem mnretodaycoll = new JMenuItem("TODAY COLLECTION");
JMenuItem mnretoexp = new JMenuItem("TODAY EXPENSE");
JMenuItem mnexit = new JMenuItem("EXIT");
JLabel lbldate = new JLabel("Date");
JTextField txtdate = new JTextField();

String[] col={"TODAY COLLECTION"};
String tcol;
    Object [] []data ={{tcol}};
    DefaultTableModel model = new DefaultTableModel(col,0); 
JTable sttbl=new JTable(data,col);
    JScrollPane spanel = new JScrollPane(sttbl);

String[] col3={"TODAY EXPENSE"};
String texp;
    Object [] []data3 ={{texp}};
    DefaultTableModel model3 = new DefaultTableModel(col3,0); 
JTable sttbl3=new JTable(data3,col3);
    JScrollPane spanel3 = new JScrollPane(sttbl3);

String[] col1={"Reg.No","Name","Amount"};
String reg,name,amt;
    Object [] []data1 ={{reg},{name},{amt}};
    DefaultTableModel model1 = new DefaultTableModel(col1,0); 
JTable sttbl1=new JTable(data1,col1);
    JScrollPane spanel1 = new JScrollPane(sttbl1);


String[] col2={"Event Type","Event Name","Date"};
String et,en,dat;
    Object [] []data2 ={{et},{en},{dat}};
    DefaultTableModel model2 = new DefaultTableModel(col2,0); 
JTable sttbl2=new JTable(data2,col2);
    JScrollPane spanel2 = new JScrollPane(sttbl2);


public dash()
{
 setTitle("Dash Board");
SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy");
Date dt = new Date();
txtdate.setText(sd.format(dt));
setSize(2000,2000);
setVisible(true);
setLayout(null);
lblimg.setBounds(-20,-200,2000,2000);
lbldate.setBounds(1550,10,100,40);
txtdate.setBounds(1600,10,200,40);
lbllogo.setBounds(40,0,250,200);
mnmast.add(mnmaststu);
mnmast.add(mnmastspo);
mnmast.add(mnmasteve);
mnmast.add(mnmastven);
mnmast.add (mnmateach);
mntran.add(mntranass);
mntran.add(mntranfund);
mntran.add(mntranspass);
mntran.add(mntranexp);
mnre.add(mnreassreport);
mnre.add(mnrefundreport);
mnre.add(mnretodaycoll);
mnre.add(mnretoexp);
mnex.add(mnexit);
mb.add(mnmast);
mb.add(mntran);
mb.add(mnre);
mb.add(mnex);
add (btntoexp);
add(btnevcal);
add(lbldate);
add(txtdate);
add(btntocoll);
add (btnsp);
add (btntea);
add(mb);
add (cbev);
btnevcal.setBounds(870,130,200,100);
sttbl2.setModel(model2);
spanel2.setBounds(870,230,200,150);
add (spanel2);
cbev.setBounds(920,230,130,30);
btntocoll.setBounds(350,130,200,100);
sttbl.setModel(model);
spanel.setBounds(350,230,200,150);
add (spanel);
btntoexp.setBounds(1110,130,200,100);
sttbl3.setModel(model3);
spanel3.setBounds(1110,230,200,150);
add (spanel3);
btnfund.setBounds(610,130,200,100);
sttbl1.setModel(model1);
spanel1.setBounds(610,230,200,150);
add (spanel1);


pnl.setBounds(-20,-200,2000,2000);
btn.setBounds(0,0,320,1000);
btntea.setBounds(0,260,320,90);
btnsp.setBounds(0,380,320,80);

btnstu.setBounds(0,500,320,80);
btn.setBackground(Color.BLACK);
lbldate.setForeground(Color.WHITE);
add(btnstu);
add(btnfund);
add(btnsp);
//add(lbllogo);

add(btn);
this.setJMenuBar(mb);
pnl.add(lblimg);
add(lblimg);
btn.setEnabled(false);
mb.setBackground(new Color(102,51,0));
Font f1 = new Font("Californian FB",Font.BOLD,20);
Font f2 = new Font("Californian FB",Font.BOLD,18);
mnmast.setFont(f1);
mnexit.setFont(f1);
mnex.setFont(f1);
mntran.setFont(f1);
mnre.setFont(f1);
lbldate.setFont(f1);
txtdate.setFont(f2);
cbev.setFont(f2);
txtdate.setEnabled(false);
mnmast.setForeground(Color.WHITE);
mnex.setForeground(Color.WHITE);
mntran.setForeground(Color.WHITE);
mnre.setForeground(Color.WHITE);
mnmasteve.addActionListener(this);
mnmastspo.addActionListener(this);
mnmaststu.addActionListener(this);
mnmastven.addActionListener(this);
mnmateach.addActionListener(this);
mntranass.addActionListener(this);
mntranfund.addActionListener(this);
mnretoexp.addActionListener(this);
mntranspass.addActionListener(this);
mntranexp.addActionListener(this);
mnreassreport.addActionListener(this);
mnrefundreport.addActionListener(this);
mnretodaycoll.addActionListener(this);
mnexit.addActionListener(this);
this.setJMenuBar(mb);
btnsp.addActionListener(this);
btntea.addActionListener(this);
btnfund.addActionListener(this);
btnstu.addActionListener(this);
btnevcal.addActionListener(this);
btntocoll.addActionListener(this);
btntoexp.addActionListener(this);

mnmast.addMouseListener(this);
mnmast.addMouseMotionListener(this);
mntran.addMouseListener(this);
mntran.addMouseMotionListener(this);
mnre.addMouseListener(this);
mnre.addMouseMotionListener(this);
mnex.addMouseListener(this);
mnex.addMouseMotionListener(this);
btnstu.addMouseListener(this);
btnstu.addMouseMotionListener(this);
cbev.addItemListener(this);
btnsp.addMouseListener(this);
btnsp.addMouseMotionListener(this);
btnfund.addMouseListener(this);
btnfund.addMouseMotionListener(this);
btntea.addMouseListener(this);
btntea.addMouseMotionListener(this);
btntocoll.addMouseListener(this);
btntocoll.addMouseMotionListener(this);
btntoexp.addMouseListener(this);
btntoexp.addMouseMotionListener(this);
btnevcal.addMouseListener(this);
btnevcal.addMouseMotionListener(this);
repaint();
}


public void itemStateChanged(ItemEvent ie)
{
if(ie.getSource()==cbev)
{   
  cbev.setVisible(false);
spanel2.setVisible(true);
try
{
model2.setRowCount(0);
Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
    Statement st = con.createStatement();
ResultSet res = st.executeQuery("select * from eventscheduletbl where eventtype='"+cbev.getSelectedItem()+"'");
while(res.next())
{
Vector v= new Vector();
v.add(res.getString(1));
v.add(res.getString(2));
v.add(res.getString(5));
model2.addRow(v);
}
con.close();
}
catch(Exception ee)
{
System.out.println(ee);
}
}
}

public void mouseMoved(MouseEvent e)
{
spanel.setVisible(false);
spanel1.setVisible(false);
spanel2.setVisible(false);
spanel3.setVisible(false);
if(e.getSource()==mnmast)
{
mnmast.setForeground(new Color(255,159,17));
mntran.setForeground(Color.WHITE);
mnre.setForeground(Color.WHITE);
mnex.setForeground(Color.WHITE);
}
if(e.getSource()==mntran)
{
mnmast.setForeground(Color.WHITE);
mntran.setForeground(new Color(255,159,17));
mnre.setForeground(Color.WHITE);
mnex.setForeground(Color.WHITE);
}
if(e.getSource()==mnre)
{
mnmast.setForeground(Color.WHITE);
mntran.setForeground(Color.WHITE);
mnre.setForeground(new Color(255,159,17));
mnex.setForeground(Color.WHITE);
}
if(e.getSource()==mnex)
{
mnmast.setForeground(Color.WHITE);
mntran.setForeground(Color.WHITE);
mnre.setForeground(Color.WHITE);
mnex.setForeground(new Color(255,159,17));
}
if(e.getSource()==btnstu)
{
btnstu.setBackground(new Color(255,255,159));
btnevcal.setBackground(new Color(255,255,0));
btnfund.setBackground(new Color(255,255,0));
btnsp.setBackground(new Color(255,255,0));
btntea.setBackground(new Color(255,255,0));
btntocoll.setBackground(new Color(255,255,0));
spanel.setVisible(false);
spanel1.setVisible(false);
spanel2.setVisible(false);
spanel3.setVisible(false);
cbev.setVisible(false);

}
if(e.getSource()==btnevcal)
{ 
btnstu.setBackground(new Color(255,255,0));
btnevcal.setBackground(new Color(255,255,159));
btnfund.setBackground(new Color(255,255,0));
btnsp.setBackground(new Color(255,255,0));
btntea.setBackground(new Color(255,255,0));
btntocoll.setBackground(new Color(255,255,0));
spanel.setVisible(false);
spanel1.setVisible(false);
spanel2.setVisible(false);
spanel3.setVisible(false);
cbev.setVisible(true);
try
            {      
      cbev.removeAllItems();
          Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
      Statement st = con.createStatement();
  ResultSet res = st.executeQuery("select distinct eventtype from Calendar");
  cbev.addItem("--Select--");
while(res.next())
{
cbev.addItem(res.getString(1));
}
cbev.setVisible(true);

             con.close(); 
}
       catch(Exception ee)
{
    System.out.println(ee);
} 
}
if(e.getSource()==btnfund)
{
String st="";
int sum=0;
btnstu.setBackground(new Color(255,255,0));
btnevcal.setBackground(new Color(255,255,0));
btnfund.setBackground(new Color(255,255,159));
btnsp.setBackground(new Color(255,255,0));
btntea.setBackground(new Color(255,255,0));
btntocoll.setBackground(new Color(255,255,0));
spanel.setVisible(false);
spanel1.setVisible(true);
spanel2.setVisible(false);
spanel3.setVisible(false);
cbev.setVisible(false);

try
{
model1.setRowCount(0);
    Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
      Statement st1 = con.createStatement();
                 ResultSet res = st1.executeQuery("select * from fundcolltbl");

    while(res.next())
        {
st=(res.getString(5));
Vector v = new Vector();
v.add(res.getString(2));
v.add(res.getString(3));
v.add(st);
model1.addRow(v);
sum=sum+Integer.parseInt(st);
}
Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
      Statement st2 = con1.createStatement();
                 ResultSet res1 = st2.executeQuery("select * from fundcolltbl2");

    while(res1.next())
        {
st=(res1.getString(5));
Vector v = new Vector();
v.add(res1.getString(2));
v.add(res1.getString(3));
v.add(st);
model1.addRow(v);
sum=sum+Integer.parseInt(st);
}

Vector v1= new Vector();
v1.add("Total");
v1.add("");
        v1.add(sum);
model1.addRow(v1);
con.close();
con1.close();
}
             catch(Exception ee)
{
System.out.println(ee);
} 
}
if(e.getSource()==btnsp)
{
btnstu.setBackground(new Color(255,255,0));
btnevcal.setBackground(new Color(255,255,0));
btnfund.setBackground(new Color(255,255,0));
btnsp.setBackground(new Color(255,255,159));
btntea.setBackground(new Color(255,255,0));
btntocoll.setBackground(new Color(255,255,0));
spanel.setVisible(false);
spanel1.setVisible(false);
spanel2.setVisible(false);
spanel3.setVisible(false);
cbev.setVisible(false);
}
if(e.getSource()==btntea)
{
btnstu.setBackground(new Color(255,255,0));
btnevcal.setBackground(new Color(255,255,0));
btnfund.setBackground(new Color(255,255,0));
btnsp.setBackground(new Color(255,255,0));
btntea.setBackground(new Color(255,255,159));
btntocoll.setBackground(new Color(255,255,0));
spanel.setVisible(false);
spanel1.setVisible(false);
spanel2.setVisible(false);
spanel3.setVisible(false);
cbev.setVisible(false);
}
if(e.getSource()==btntocoll)
{ 
       int sumamt=0;
btnstu.setBackground(new Color(255,255,0));
btnevcal.setBackground(new Color(255,255,0));
btnfund.setBackground(new Color(255,255,0));
btnsp.setBackground(new Color(255,255,0));
btntea.setBackground(new Color(255,255,0));
btntocoll.setBackground(new Color(255,255,159));
spanel.setVisible(true);
spanel1.setVisible(false);
spanel2.setVisible(false);
spanel3.setVisible(false);
cbev.setVisible(false);
try
{
    Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
      Statement st = con.createStatement();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date da = new Date();

                 ResultSet res = st.executeQuery("select amount from fundcolltbl where paiddate='"+(sdf.format(da))+"'");
    while(res.next())
        {
sumamt=sumamt+Integer.parseInt(res.getString(1));
}

Connection con1 = DriverManager.getConnection("jdbc:odbc:eventdsn");
      Statement st1 = con1.createStatement();
SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        Date da1 = new Date();

                 ResultSet res1 = st1.executeQuery("select amount from fundcolltbl2 where paiddate='"+(sdf1.format(da1))+"'");
    while(res1.next())
        {
sumamt=sumamt+Integer.parseInt(res1.getString(1));
}

    model.setRowCount(0);
Vector v= new Vector();
v.add(sumamt);
model.addRow(v);
 con.close();
 con1.close();
}
catch(Exception ee)
{
System.out.println(ee);
}
}
if(e.getSource() == btntoexp)
{
int sumamt=0;
btnstu.setBackground(new Color(255,255,0));
btnevcal.setBackground(new Color(255,255,0));
btnfund.setBackground(new Color(255,255,0));
btnsp.setBackground(new Color(255,255,0));
btntea.setBackground(new Color(255,255,0));
btntocoll.setBackground(new Color(255,255,159));
spanel.setVisible(false);
spanel1.setVisible(false);
spanel2.setVisible(false);
spanel3.setVisible(true);
try
{
Connection con = DriverManager.getConnection("jdbc:odbc:eventdsn");
      Statement st = con.createStatement();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date da = new Date();

                 ResultSet res = st.executeQuery("select amount from expensetbl where expensedate='"+(sdf.format(da))+"'");
    while(res.next())
        {
sumamt=sumamt+Integer.parseInt(res.getString(1));
}
     model3.setRowCount(0);
 Vector v= new Vector();
     v.add(sumamt);
 model3.addRow(v);
     con.close();
   }
catch(Exception ee)
{
System.out.println(ee);
}
}
}


public void mouseExited(MouseEvent e)
{

}
public void mouseEntered(MouseEvent e)
{

}
public void mousePressed(MouseEvent e)
{

}
public void mouseReleased(MouseEvent e)
{

}
public void mouseClicked(MouseEvent e)
{

}
public void mouseDragged(MouseEvent e)
{

}

public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==mnmaststu)
{
Student ob = new Student();
}
if(e.getSource()==mnmastspo)
{
sponserTable ob = new sponserTable();
}
if(e.getSource()==mnmasteve)
{
Calendar ob = new Calendar();
}
if(e.getSource()==mnmastven)
{
Venue ob =  new Venue();
}
if(e.getSource()==mnmateach)
{
Teacher ob =  new Teacher();
} 
if(e.getSource()==mntranass)
{
Assignment ob = new Assignment();
}
if(e.getSource()==mntranfund)
{
fundcoll ob = new fundcoll();
}
if(e.getSource()==mntranspass)
{
Sponserassigned ob = new Sponserassigned();
}
if(e.getSource()==mntranexp)
{
 expense ob = new expense();
}
if(e.getSource() == mnreassreport)
{
assignmentreport ob = new assignmentreport();
}
if(e.getSource() == mnretodaycoll)
{
todaycoll ob = new todaycoll();
}
if(e.getSource()== mnretoexp)
{
	todayexpense ob=new todayexpense();
}
if(e.getSource() == mnrefundreport)
{
fundreport ob = new fundreport();
}
if(e.getSource() == mnexit)
{
this.dispose();
}
if(e.getSource()==btntea)
{
	Teacher ob =  new Teacher();
}
if(e.getSource()==btnsp)
{
	sponserTable ob = new sponserTable();
}
if(e.getSource() == btnfund)
{
   fundreport ob = new fundreport(); 
}
if(e.getSource() == btnstu)
{
Student ob = new Student();
}
if(e.getSource() ==  btnevcal)
{
	Calendar ob = new Calendar();
}
if(e.getSource() == btntocoll)
{
	todaycoll ob = new todaycoll();
}
if(e.getSource() == btntoexp)
{
	todayexpense ob = new todayexpense();
}

}
public static void main(String arg[])
{
dash obj = new dash();
}
}