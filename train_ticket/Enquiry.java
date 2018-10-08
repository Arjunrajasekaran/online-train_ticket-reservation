package train_ticket;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Enquiry  implements ActionListener {
	JFrame f;
	JLabel l1,l2;
	JTextField t;
	List li;
	JButton b1,b2;
	PreparedStatement ps;
	ResultSet rs;
	Connection con ;
	Enquiry()
	{
	f=new JFrame("PNR-Enquiry");
	f.getContentPane().setLayout(null);
	f.getContentPane().setBackground(Color.green);
	l1=new JLabel("PNR No");
	l1.setBounds(50,50,60,30);
	l2=new JLabel("PNR Details");
	l2.setBounds(50,80,100,30);
	t=new JTextField(10);
	t.addActionListener(this);
	t.setBounds(110,50,150,30);
	li=new List();
	li.setBounds(50,110,390,180);
	b1=new JButton("Check");
	b1.setBackground(Color.yellow);
	b1.addActionListener(this);
	b1.setBounds(70,300,100,30);
	b2=new JButton("Back");
	b2.setBackground(Color.yellow);
	b2.addActionListener(this);
	b2.setBounds(210,300,100,30);

	b1.setMnemonic('C');
	b2.setMnemonic('B');

	f.getContentPane().add(l1);
	f.getContentPane().add(l2);
	f.getContentPane().add(t);
	f.getContentPane().add(li);
	f.getContentPane().add(b1);
	f.getContentPane().add(b2);

	f.setSize(1300,1000);
	f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
	if(e.getSource()==b1)
	{
	try
	{ Connection con=DriverManager.getConnection("jdbc:ucanaccess://C:\\WORKSPACE\\train_ticket\\src\\train_ticket\\Railway.mdb");
    
		
	//reservation information
	ps=con.prepareStatement("select * from Reservation where PNR_No=?");
	ps.setString(1,t.getText());
	rs=ps.executeQuery();
	rs.next();
	li.clear();
	li.add("Train No.: "+rs.getString(2));
	li.add("Train Name: "+rs.getString(3));
	li.add("Class: "+rs.getString(4));
	li.add("Date of Journey: "+rs.getString(5));
	li.add("From: "+rs.getString(6));
	li.add("To: "+rs.getString(7));
	li.add("Boarding at: "+rs.getString(8));

	//passeneger information
	ps=con.prepareStatement("select * from Passenger where PNR_No=?");
	ps.setString(1,t.getText());
	rs=ps.executeQuery();
	while(rs.next())
	{
	li.add("Passenger Name: "+rs.getString(2));
	li.add("Age: "+rs.getString(3));
	li.add("Gender: "+rs.getString(4));
	}
	}
	catch(Exception e1)
	{
	System.out.println("connection failed:"+e1);
	}
	}
	if(e.getSource()==b2)
	{
	f.setVisible(false);
	new Main();
	}
	}
	public static void main(String args[])
	{
	new Enquiry();
	}



}
