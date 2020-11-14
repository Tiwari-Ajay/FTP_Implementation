
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class   Server_Setting extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4;JFrame frame1;Cursor cur1,cur2;JTextField t1,t2;
	  Server_Setting(){
	    frame1=new JFrame();
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(100,100,700,500);
	    frame1.setTitle("Server Setting");
		ImageIcon icon1=new ImageIcon("image_use.jpg"); //for icon in page
		frame1.setIconImage(icon1.getImage());
		Container c=frame1.getContentPane();
		c.setBackground(Color.ORANGE);
		c.setLayout(null);
		ImageIcon icon2 = new ImageIcon("Ftp_logo.jpg");
		JLabel  l1= new JLabel(icon2);  // image on page
        l1.setBounds(300,0,100,100);
        c.add(l1);
        JLabel l2=new JLabel();		// for welcome text	
		l2.setText("!! Server Setting !!");
		l2.setBounds(135,100,500,100);
		Font f=new Font("Arial",Font.PLAIN,50);  //font declaration
		Font f2=new Font("Arial",Font.PLAIN,30);  //font declaration
		Font f3=new Font("Arial",Font.PLAIN,20);  //font declaration
		l2.setFont(f);
		l2.setForeground(Color.BLUE);
		c.add(l2);
		cur1=new Cursor(Cursor.HAND_CURSOR);
		cur2=new Cursor(Cursor.WAIT_CURSOR);
		 JLabel l3= new JLabel(); // l3 to IP ADDRESS
		l3.setText("Sender Port Number : ");
		l3.setBounds(20,230,350,50);
		l3.setFont(f2);
		l3.setForeground(Color.BLUE);
		c.add(l3); //end l3
		t1=new JTextField("1980");   // t1 (start) Sender Port JTEXTFIELD
        t1.setBounds(400,230,280,50); 
		t1.setBackground(Color.YELLOW);
		t1.setForeground(Color.BLACK);
		t1.setFont(f3);
         c.add(t1); 	// t1  end
		  JLabel l4= new JLabel(); // l4 to port LABEL 
		l4.setText("Receiver Port Number :");
		l4.setBounds(20,300,350,50);
		l4.setFont(f2);
		l4.setForeground(Color.BLUE);
		c.add(l4); //end l4
		 t2=new JTextField("1990");   // t2 (start)Receiver port number JTEXTFIELD
        t2.setBounds(400,300,280,50); 
		t2.setBackground(Color.YELLOW);
		t2.setForeground(Color.BLACK);
		t2.setFont(f3);
         c.add(t2); 	// t2  end
		 b2=new JButton();  //Message button creation
		b2.setText("Message");
		b2.setFont(f2);
		b2.setForeground(Color.BLUE);
		b2.setBackground(Color.CYAN);
		b2.setBounds(181,400,160,50);
		b2.setCursor(cur1);
		b2.addActionListener(this);
		c.add(b2);
		
		 b1=new JButton();  //Close button creation
		b1.setText("Close");
		b1.setFont(f2);
		b1.setForeground(Color.BLUE);
		b1.setBackground(Color.CYAN);
		b1.setBounds(524,400,160,50);
		b1.setCursor(cur2);
		b1.addActionListener(this);
		c.add(b1);
		b3=new JButton();  //file button creation
		b3.setText("File");
		b3.setFont(f2);
		b3.setForeground(Color.BLUE);
		b3.setBackground(Color.CYAN);
		b3.setBounds(353,400,160,50);
		b3.setCursor(cur1);
		b3.addActionListener(this);
		c.add(b3);
		b4=new JButton();  //Back button creation
		b4.setText("Back");
		b4.setFont(f2);
		b4.setForeground(Color.BLUE);
		b4.setBackground(Color.CYAN);
		b4.setBounds(10,400,160,50);
		b4.setCursor(cur2);
		b4.addActionListener(this);
		c.add(b4);
		frame1.setResizable(false);
      }
     public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
          frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame1.dispose();
        }
       else  if(e.getSource()==b2)
	   {
		    String s1=t1.getText();
		   String s2=t2.getText();
		   int port1=Integer.parseInt(s1);
		  int port2=Integer.parseInt(s2);
		 MessageServer m1 =  new MessageServer();
		 m1.run1(port1,port2);
	   }
	   else  if(e.getSource()==b3)
	   { 
        try{
		   String s1=t1.getText();
		   String s2=t2.getText();
		   int port1=Integer.parseInt(s1);
		  int port2=Integer.parseInt(s2);
		   new FtpFileServer(port1,port2);
		}
		catch(Exception e7)
		{
			System.out.println(e7);
		}
	   }
	   else
	   {
	   frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.dispose();
		new Setting();
	   }
    }	  
  	public static void main(String [] args)
	{
		new Server_Setting();
	}
		
}