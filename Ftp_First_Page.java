
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Ftp_First_Page extends JFrame implements ActionListener
{
	JButton b1,b2;JFrame frame1;Cursor cur1,cur2;
	  Ftp_First_Page(){
	    frame1=new JFrame();
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(100,100,700,500);
	    frame1.setTitle("Ftp First Page");
		ImageIcon icon1=new ImageIcon("image_use.jpg"); //for icon in page
		frame1.setIconImage(icon1.getImage());
		Container c=frame1.getContentPane();
		c.setBackground(Color.YELLOW);
		c.setLayout(null);
		ImageIcon icon2 = new ImageIcon("Ftp_logo.jpg");
		JLabel  l1= new JLabel(icon2);  // image on page
        l1.setBounds(300,50,100,100);
        c.add(l1);
        JLabel l2=new JLabel();		// for welcome text	
		l2.setText("!! Welcome in My Ftp !!");
		l2.setBounds(200,150,320,100);
		Font f=new Font("Arial",Font.PLAIN,30);  //font declaration
		Font f2=new Font("Arial",Font.PLAIN,20);  //font declaration
		l2.setFont(f);
		l2.setForeground(Color.BLUE);
		c.add(l2);
		cur1=new Cursor(Cursor.HAND_CURSOR);
		cur2=new Cursor(Cursor.WAIT_CURSOR);
		 b1=new JButton();  //close button creation
		b1.setText("Close");
		b1.setFont(f2);
		b1.setForeground(Color.BLUE);
		b1.setBackground(Color.CYAN);
		b1.setBounds(100,400,150,50);
		b1.setCursor(cur1);
		b1.addActionListener(this);
		c.add(b1);
		
		 b2=new JButton();  //next button creation
		b2.setText("Next");
		b2.setFont(f2);
		b2.setForeground(Color.BLUE);
		b2.setBackground(Color.CYAN);
		b2.setBounds(450,400,150,50);
		b2.setCursor(cur2);
		b2.addActionListener(this);
		c.add(b2);
		frame1.setResizable(false);
      }
     public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
          frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame1.dispose();
        }
       
	else{
			new Setting();
			frame1.dispose();
		}
    }	  
	public static void main(String [] args)
	{
		new Ftp_First_Page();
	}
		
}