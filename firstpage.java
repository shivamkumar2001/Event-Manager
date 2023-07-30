import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
public class firstpage extends JFrame implements ActionListener
{
JButton btnConfirm=new JButton("Confirm");
JButton btnCancel=new JButton("Cancel");
JLabel lbcoll=new JLabel("Institute of Technical Education and Reserach");
JLabel lbeve=new JLabel("Event Management System");
JLabel lbdev=new JLabel("Developed By:");
JLabel lbname=new JLabel ("Shivam Kumar");
JLabel lbimg=new JLabel (new ImageIcon("lg.png"));

public firstpage ()
{
setLayout(null);
setVisible(true);
setSize(1000,1000);
lbcoll.setBounds(200,20,600,100);
lbimg.setBounds(350,150,200,100);
lbeve.setBounds(360,270,300,100);
lbdev.setBounds(570,290,400,200);
lbname.setBounds(630,380,300,100);
btnConfirm.setBounds(200,570,90,50);
btnCancel.setBounds(600,570,90,50);
Font f1 = new Font("Monotype Corsiva",Font.BOLD,30);
lbcoll.setForeground(new Color(100,0,60));
lbcoll.setFont(f1);
Font f2 = new Font("Monotype Corsiva",Font.BOLD,20);
lbeve.setForeground(new Color(100,0,60));
lbeve.setFont(f2);
add (lbcoll);
add (lbimg);
add (lbeve);
add (lbdev);
add (lbname);
add (btnConfirm);
add (btnCancel);
btnConfirm.addActionListener(this);
btnCancel.addActionListener(this);
 }
  public void actionPerformed (ActionEvent e)
  {
   if(e.getSource() == btnConfirm)
   {
     login obj = new login();
     this.dispose();
   }
   if(e.getSource() == btnCancel)
   {
     this.dispose();
   }
  }
 public static void main (String args[])
 {
  firstpage obj = new firstpage();
 }
 }  






