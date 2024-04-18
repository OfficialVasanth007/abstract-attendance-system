import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
public class main {
     ImageIcon back=new ImageIcon("arrow.png");
     
	
	public void login()
		{
		JFrame frame1=new JFrame("Login");
		frame1.getContentPane().setBackground(Color.BLACK);
		
		JLabel login=new JLabel("Welcome to Login window !!!");
		login.setBounds(110,5,300,50);
		login.setForeground(Color.WHITE);
		login.setFont(new Font("ittalic",Font.BOLD,18));
		
		JLabel ls=new JLabel("Login as");
		ls.setBounds(190,100,200,50);
		ls.setForeground(Color.ORANGE);
		ls.setFont(new Font("ittalic",Font.BOLD,18));
		
		JButton student=new JButton("Student");
		student.setBounds(80,170,150,50);
		student.setForeground(Color.RED);
		student.setFont(new Font("ittalic",Font.BOLD,18));
		
		JButton teacher=new JButton("Teacher");
		teacher.setBounds(250,170,150,50);
		teacher.setForeground(Color.RED);
		teacher.setFont(new Font("ittalic",Font.BOLD,18));
		
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(500,400);
		frame1.setLayout(null);
		frame1.setLocationRelativeTo(null);
		frame1.setResizable(false);
		
		frame1.add(login);
		frame1.add(ls);
		frame1.add(student);
		frame1.add(teacher);
			
		student.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
					frame1.dispose();
					student();
					}

				}
				
				);
		teacher.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			frame1.dispose();
			Teacher();
			}

		}
		
		);
		}
	public void student()
	{
		JButton back1=new JButton("BACK");
		back1.setBounds(290,350,100,100);
		 back1.setBackground(Color.decode("#01C38D"));
	        back1.setForeground(Color.decode("#132D46"));
	       back1.setBounds(220,350,150,30);
		
		
		JLabel Topic=new JLabel("Student Attendance");
		Topic.setFont(new Font("Italic",Font.BOLD,20));
		Topic.setBounds(150,20,300,50);
		Topic.setForeground(Color.cyan);
		
		JLabel user=new JLabel("UserName");
		user.setFont(new Font("Italic",Font.BOLD,18));
		user.setBounds(80,150,250,50);
		user.setForeground(Color.cyan);
		 
		JTextField userIn=new JTextField();
		userIn.setBounds(200,160,190,30);
		userIn.setBackground(Color.decode("#132D46"));
        userIn.setForeground(Color.decode("#01C38D"));

		JLabel pass=new JLabel("Password");
		pass.setFont(new Font("Italic",Font.BOLD,18));
		pass.setBounds(80,210,250,50);
		pass.setForeground(Color.cyan);
		
		 
		JTextField passIn=new JTextField();
		passIn.setBounds(200,220,190,30);
		passIn.setBackground(Color.decode("#132D46"));
        passIn.setForeground(Color.decode("#01C38D"));
        
        JButton Login2= new JButton("LOGIN");
        Login2.setBackground(Color.decode("#01C38D"));
        Login2.setForeground(Color.decode("#132D46"));
        Login2.setBounds(220,290,150,30);
        
        JLabel msg=new JLabel("Login to Record Attendance");
        msg.setFont(new Font("Italic",Font.BOLD,15));
		msg.setBounds(150,550,300,50);
		msg.setForeground(Color.cyan);
	
		
		JFrame frame2=new JFrame("Student");
		frame2.getContentPane().setBackground(Color.BLACK);
		frame2.setVisible(true);
		frame2.setSize(500,700);
		frame2.setLocationRelativeTo(null);
		frame2.setResizable(false);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.add(Topic);
		frame2.add(user);frame2.add(userIn);
		frame2.add(pass);frame2.add(passIn);
		frame2.add(Login2);
		frame2.add(back1);
		frame2.add(msg);
		frame2.setLayout(null);
		
		Login2.addActionListener(new ActionListener()
				
				{
					public void actionPerformed(ActionEvent e) {
						try
						{
						String query="select * from student where user = '"+userIn.getText()+"'"+"and pass ='"+passIn.getText()+"'";
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","vasanthvasanth");
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery(query);
						if(rs.next())
						{
						JOptionPane.showMessageDialog(null,"ATTENDANCE CONFIRMED");
						st.executeUpdate("update student set att=1 where user = '"+userIn.getText()+"'");
						//st.executeUpdate("update student set att=null ");
						}
						else
						{
							JOptionPane.showMessageDialog(null,"invalid username/password");
						}
					}
						catch(Exception ee)
						{
							JOptionPane.showMessageDialog(null,ee.getMessage());
						}
					}
				});
		back1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						frame2.dispose();
						login();
					}
			
				});
		
	}
	public void Teacher()
	{
		JFrame frame3=new JFrame("Teacher");
		
		 JButton back1=new JButton("BACK");
		  back1.setBounds(290,350,100,100);
		    back1.setBackground(Color.decode("#01C38D"));
	         back1.setForeground(Color.decode("#132D46"));
	        back1.setBounds(250,350,150,30);
	       
		JLabel topic3=new JLabel("Teacher Login");
		topic3.setFont(new Font("Italic",Font.BOLD,20));
		topic3.setBounds(150,20,300,50);
		topic3.setForeground(Color.cyan);
		
		JLabel user=new JLabel("UserName");
		user.setFont(new Font("Italic",Font.BOLD,20));
		user.setBounds(80,150,200,50);
		user.setForeground(Color.cyan);
		
		JTextField userIn=new JTextField();
		userIn.setBackground(Color.decode("#132D46"));
        userIn.setForeground(Color.decode("#01C38D"));
        userIn.setBounds(250,163,150,25);
        
		JLabel pass=new JLabel("Password");
		pass.setFont(new Font("Italic",Font.BOLD,20));
		pass.setBounds(80,210,200,50);
		pass.setForeground(Color.cyan);
		
		JTextField passIn=new JTextField();
		passIn.setBackground(Color.decode("#132D46"));
        passIn.setForeground(Color.decode("#01C38D"));
        passIn.setBounds(250,220,150,25);
		
        JButton Login2= new JButton("LOGIN");
        Login2.setBackground(Color.decode("#01C38D"));
        Login2.setForeground(Color.decode("#132D46"));
        Login2.setBounds(250,290,150,30);
	
		
		frame3.getContentPane().setBackground(Color.BLACK);
		frame3.setVisible(true);
		frame3.setSize(500,700);
		frame3.setLocationRelativeTo(null);
		frame3.setResizable(false);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setLayout(null);
		
		frame3.add(topic3);
		frame3.add(user);frame3.add(userIn);
		frame3.add(pass);frame3.add(passIn);
		frame3.add(Login2);
		frame3.add(back1);
		
		Login2.addActionListener(new ActionListener ()
				{
					public void actionPerformed(ActionEvent e) {
						try {
							String query="select * from teacher where user = '"+userIn.getText()+"'"+"and pass ='"+passIn.getText()+"'";
							Connection con22=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","vasanthvasanth");
							Statement sts=con22.createStatement();
							ResultSet rss=sts.executeQuery(query);
							if(rss.next()) {
						frame3.dispose();
						JOptionPane.showMessageDialog(null,"successfully loged in");
						finallresult();	
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Invalid username/password");
							}
						}
						catch(Exception e33)
						{
							JOptionPane.showMessageDialog(null, e33.getMessage());
						}
					}
				});
		back1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
				frame3.dispose();
				login();
				
			}
	
		});	
	}
	public void finallresult()
		{
		JFrame frame4=new JFrame("result");
		
		    JButton as=new JButton("ALL STUDENT");
		    as.setBackground(Color.decode("#01C38D"));
	        as.setForeground(Color.decode("#132D46"));
	        as.setBounds(80,70,130,30);
		
	        JButton ps=new JButton("PRESENT");
		    ps.setBackground(Color.decode("#01C38D"));
	        ps.setForeground(Color.decode("#132D46"));
	        ps.setBounds(250,70,130,30);
	        
				
		frame4.getContentPane().setBackground(Color.BLACK);
		frame4.setVisible(true);
		frame4.setSize(500,700);
		frame4.setLocationRelativeTo(null);
		frame4.setResizable(false);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setLayout(null);
		frame4.add(as);
		frame4.add(ps);
		 
		as.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						try
						{
							String query = "SELECT user FROM student";
			                Connection con23 = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "vasanthvasanth");
			                Statement stt = con23.createStatement();
			                ResultSet rsr = stt.executeQuery(query);

			                int y = 150; // Initial y-coordinate for positioning student names
                       
			                while (rsr.next()) {
			               JLabel r1    = new JLabel(rsr.getString(1));
			                    r1.setFont(new Font("Italic", Font.BOLD, 15));
			                    r1.setBounds(80, y, 200, 50);
			                    r1.setForeground(Color.cyan);
			                   
			                    frame4.add(r1);

			                    // Increment y-coordinate for the next student name
			                    y += 40; // Adjust as needed to leave space between student names
			                }

			                frame4.revalidate(); // Revalidate the frame to update the layout
			                frame4.repaint();   
						}
						catch(Exception eee)
						{
							JOptionPane.showInternalMessageDialog(null, eee.getMessage());
						}
					}
		});
		ps.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				try
				{ 
					
					String query = "SELECT user FROM student where att=1";
	                Connection con23 = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "vasanthvasanth");
	                Statement stt = con23.createStatement();
	                ResultSet rsr = stt.executeQuery(query);
	                
	              

	                int y = 150; // Initial y-coordinate for positioning student names
               
	                while (rsr.next()) {
	                    JLabel r2 = new JLabel(rsr.getString(1));
	                    r2.setFont(new Font("Italic", Font.BOLD, 15));
	                    r2.setBounds(280, y, 200, 50);
	                    r2.setForeground(Color.cyan);
	                   
	                    frame4.add(r2);

	                    // Increment y-coordinate for the next student name
	                    y += 40; // Adjust as needed to leave space between student names
	                }

	                frame4.revalidate(); // Revalidate the frame to update the layout
	                frame4.repaint();   
				}
				catch(Exception eee)
				{
					JOptionPane.showInternalMessageDialog(null, eee.getMessage());
				}
			}
});
	
			
		}
	public static void main(String[] args) {
		
		main m=new main();
		m.login();
		

	}

}
