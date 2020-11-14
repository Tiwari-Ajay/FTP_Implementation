
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Sender_File extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4;JFrame frame1;Cursor cur1,cur2;JTextField t1,t2;
	String ip;int port;
	  Sender_File(String ip1,int port1){
		  //System.out.println(ip1+" "+port1);
		ip=ip1;port=port1;  
	    frame1=new JFrame();
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(100,100,700,500);
	    frame1.setTitle("Sender File");
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
		l2.setText("!! File Sender !!");
		l2.setBounds(170,100,400,100);
		Font f=new Font("Arial",Font.PLAIN,50);  //font declaration
		Font f2=new Font("Arial",Font.PLAIN,30);  //font declaration
		Font f3=new Font("Arial",Font.PLAIN,20);  //font declaration
		l2.setFont(f);
		l2.setForeground(Color.BLUE);
		c.add(l2);
		cur1=new Cursor(Cursor.HAND_CURSOR);
		cur2=new Cursor(Cursor.WAIT_CURSOR);
		 JLabel l5= new JLabel(); // l5 to message label
		l5.setText("Choose File : ");
		l5.setBounds(20,220,250,50);
		l5.setFont(f2);
		l5.setForeground(Color.BLUE);
		c.add(l5); //end l5
		 JLabel l6= new JLabel(); // l6 to file name label
		l6.setText("File Name : ");
		l6.setBounds(20,300,200,50);
		l6.setFont(f2);
		l6.setForeground(Color.BLUE);
		c.add(l6); //end l6
		 t1=new JTextField();   // t1 (start)JTextField FOR FILE NAME
        t1.setBounds(200,305,480,40); 
		t1.setBackground(Color.WHITE);
		t1.setForeground(Color.BLUE);
		t1.setFont(f3);
         c.add(t1); 	// t1  end
		 b2=new JButton();  //File Chooser button creation
		b2.setText("File Chooser");
		b2.setFont(f2);
		b2.setForeground(Color.BLUE);
		b2.setBackground(Color.CYAN);
		b2.setBounds(300,225,250,40);
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
		b3.setText("Send");
		b3.setFont(f2);
		b3.setForeground(Color.BLUE);
		b3.setBackground(Color.CYAN);
		b3.setBounds(270,400,160,50);
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
       else if(e.getSource()==b2)
	   {
		  JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File f=chooser.getSelectedFile();
         String filename=f.getAbsolutePath();
        t1.setText(filename);
	   }
	   else if(e.getSource()==b3)
	   {
		   try{
		String file=t1.getText();
		
		new FtpFileClient(ip, port,file);  
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		   
	   }
	   else
	   {
		   frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.dispose();
		new Sender_Setting();
	   }
    }	  
  public static void main(String [] args)
	{
		new Sender_File("localhost",1980);
	}
		
}