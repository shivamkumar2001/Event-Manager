import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
import javax.swing.*;
public class splash1 extends JFrame implements ActionListener
{
 JButton btnok = new JButton(new ImageIcon("images/splashbutton.png"));
 Label prba= new Label();
 JLabel img=new JLabel(new ImageIcon("images/splash2.jpg"));
 JPanel pnl = new JPanel();
 Dimension d1 = Toolkit.getDefaultToolkit().getScreenSize();
 JLabel lbl = new JLabel("Loading...");
 public splash1 ()
 {
	 setTitle("Event Manager");
  setLayout(null);
  setVisible(true);
  setSize(1010,690);
  
  img.setBounds(-10,-2,1010,690);
  pnl.setBounds(-10,-100,1040,850);
  pnl.add(img);
  int x=(int)d1.getWidth()/2-505;
  int y=(int)d1.getHeight()/2-345;
  prba.setBackground(new Color(255,192,0)); 
  this.setLocation(x,y);
  btnok.setVisible(true);
  btnok.setBounds(230,560,370,40);
  Font f2 = new Font("Monotype Corsiva",Font.BOLD,15);
  Font f3 = new Font("Bernard MT Condensed",Font.BOLD,25);
  
  lbl.setBounds(320,480,200,40);
  prba.setBounds(250,550,20,30);
  add(prba);
  add(lbl);
  //add(btnok);
  add(img);
  lbl.setForeground(Color.WHITE);
  lbl.setFont(f3);
  btnok.addActionListener(this);
  repaint();
  try{
	  Thread.sleep(1000);
  }
  catch(Exception ee){}
   int xx=0;
		for(int i=1;i<=12;i++)
		{
		prba.setBounds(250,550,20+xx,30);
		xx=xx+50;
		if(i==12)
		{
			Login obj = new Login();
			this.dispose();
		}
		try
		{
		Thread.sleep(500);
		}
		catch(Exception ee){}
/*		for(double k=1;k<=9000000;k++)
		{}*/
		}
		
}
public void actionPerformed (ActionEvent e)
 {
	 if(e.getSource()==btnok)
	 {
	   
		 Login ob= new Login();
		 this.dispose();
	 }
 } 
 public static void main (String args[])
 {
  splash1 ob = new splash1();
 }
}