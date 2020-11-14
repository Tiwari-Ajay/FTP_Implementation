
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Setting extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5;JFrame frame2;Cursor cur1,cur2;
	  Setting(){
	    frame2=new JFrame();
		frame2.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setBounds(100,100,700,500);
	    frame2.setTitle("Ftp Setting");
		ImageIcon icon1=new ImageIcon("image_use.jpg"); //for icon in page
		frame2.setIconImage(icon1.getImage());
		Container c=frame2.getContentPane();
		c.setBackground(Color.GREEN);
		c.setLayout(null);
		ImageIcon icon2 = new ImageIcon("Ftp_logo.jpg");
		ImageIcon icon3 = new ImageIcon("image.jpg");
		JLabel  l1= new JLabel(icon2);  // first image on page
		JLabel  l3= new JLabel(icon3);  //second image on page
        l1.setBounds(0,0,100,100);
        l3.setBounds(600,0,100,100);
        c.add(l1);
		c.add(l3);
        JLabel l2=new JLabel();		// for l2 Setting text	(start)
		l2.setText("!! Setting !!");
		l2.setBounds(220,20,300,60);
		Font f=new Font("Arial",Font.PLAIN,50);  //font declaration
		Font f2=new Font("Arial",Font.PLAIN,30);  //font declaration
		l2.setFont(f);
		l2.setForeground(Color.BLUE);
		c.add(l2);                      //end l2 
		cur1=new Cursor(Cursor.HAND_CURSOR);
		cur2=new Cursor(Cursor.WAIT_CURSOR);
		JLabel l4= new JLabel(); // l4 to messsaging the sender
		l4.setText("For Sender : ");
		l4.setBounds(20,140,200,50);
		l4.setFont(f2);
		l4.setForeground(Color.BLUE);
		c.add(l4); //end l4
        b3=new JButton();  // b3 for l4 label(sender)  start
		b3.setText("Sender");
		b3.setFont(f2);
		b3.setForeground(Color.BLUE);
		b3.setBackground(Color.CYAN);
		b3.setBounds(300,140,200,50);
		b3.setCursor(cur1);
		b3.addActionListener(this);
		  //end of b3 for l4  label
		JLabel l5= new JLabel(); // l5 to messaging the Receiver(start)
		l5.setText("For Receiver : ");
		l5.setBounds(20,220,200,50);
		l5.setFont(f2);
		l5.setForeground(Color.BLUE);
		 c.add(l5);   //end l5
        b4=new JButton();  // b4 for l5 label Receiver  (start)
		b4.setText("Receiver");
		b4.setFont(f2);
		b4.setForeground(Color.BLUE);
		b4.setBackground(Color.CYAN);
		b4.setBounds(300,220,200,50);
		b4.setCursor(cur1);
		b4.addActionListener(this);
		  //end of b4 for l5  label
		JLabel l6= new JLabel(); // l6 to server(start)
		l6.setText("For Server : ");
		l6.setBounds(20,300,200,50);
		l6.setFont(f2);
		l6.setForeground(Color.BLUE);
		c.add(l6); //end l6
        b5=new JButton();  // b5 for l6 to server  (start)
		b5.setText("Start");
		b5.setFont(f2);
		b5.setForeground(Color.BLUE);
		b5.setBackground(Color.CYAN);
		b5.setBounds(300,300,200,50);
		b5.setCursor(cur1);
		b5.addActionListener(this);
		  //end of b5 for l6  label(server)
		 b1=new JButton();  
		b1.setText("Close");
		b1.setFont(f2);
		b1.setForeground(Color.BLUE);
		b1.setBackground(Color.ORANGE);
		b1.setBounds(500,400,150,50);
		b1.setCursor(cur1);
		b1.addActionListener(this);
		 b2=new JButton();  //Back button creation
		b2.setText("Back");
		b2.setFont(f2);
		b2.setForeground(Color.BLUE);
		b2.setBackground(Color.ORANGE);
		b2.setBounds(50,400,150,50);
		b2.setCursor(cur1);
		b2.addActionListener(this);
		//b3.addActionListener(this);
		//b4.addActionListener(this);
		//b5.addActionListener(this);
		c.add(b1);c.add(b3);c.add(b4);c.add(b5);c.add(b2);     //end of all button
			frame2.setResizable(false); 
      
	  }
     public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
          frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame2.dispose();
        }
	else if(e.getSource()==b3)
	{
    new Sender_Setting();	
	frame2.dispose();
	}
	else if(e.getSource()==b4)
	{
		new Receiver_Setting();	
		frame2.dispose();
	}
	else if(e.getSource()==b5){
		new Server_Setting();
		frame2.dispose();
	}
	else
	{
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.dispose();
		new Ftp_First_Page();
	}
  }	  
	public static void main(String [] args)
	{
		new Setting();
	}
		
}