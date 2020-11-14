//PACKAGE
//package FilePackage;

//HEADER FILES
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


class Tasker extends Thread {
	JTextArea jt;
	BufferedReader input;
	Tasker(JTextArea j, BufferedReader in) {
		jt = j;
		input = in;
	}
	
	public void run() {
		while(true){
		try {
			String mes = input.readLine();
			jt.setText(mes);
		} catch (Exception e) {
			System.out.println(e);
		}
		}
	}
	
}
//CLASS MESSAGE
 public class MessageClient extends JFrame implements ActionListener {
	
	//REFERENCE DECLARATION
	JFrame frames;
	JButton back,clear,send,close;
	JLabel lab;
	JTextArea sender, receiver;
	Cursor cu1,cu2;
	Container contain;
	
	//MessageSender messageSender;
	BufferedReader input;
	PrintStream output;
	Socket cs;
	
	//MESSAGE CLASS CONSTRUCTOR
	MessageClient(String ip,int port)
	{	
		try {
		cs = new Socket(ip,port);
		output=new PrintStream(cs.getOutputStream());
		input = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		} catch(Exception e) {
			System.out.println(e);
		}
		
		
		init();
		prisize();	
		Tasker task = new Tasker (receiver, input);
		task.start();
		
	}
	
	//FUNCTION TO INITIALIZE VERIABLES
	public void init()
	{
		//INITIALIZATION
		//JFRAME
		frames=new JFrame();
		
		//JBUTTON
		back=new JButton();
		clear=new JButton();
		send=new JButton();
		close=new JButton();
		
		//JLABEL
		lab=new JLabel();
		
		//TEXTAREA
		sender=new JTextArea();
		receiver = new JTextArea();
		
		//CURSOR
		//CR1
		cu1=new Cursor(Cursor.HAND_CURSOR);
		//CR2
		cu2=new Cursor(Cursor.WAIT_CURSOR);	
		
		//CONTAINER
		contain=frames.getContentPane();
		contain.setLayout(null);
		
		//OBJECT INITIALIZATION
		//messageSender=new MessageSender();
	}
	
	//FUNCTION TO PRISIZE VERIABLES
	public void prisize()
	{
		//JFRAME
		//FRAMES
		frames.setVisible(true);
		frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frames.setBounds(100,100,700,500);
	    frames.setTitle("MESSAGE SENDER");
	    
	    //JBUTTON
	    //BACK
		back.setText("BACK");
		back.setFont(new Font("Monaco",Font.BOLD,16));
		back.setForeground(Color.BLUE);
		back.setBackground(Color.CYAN);
		back.setBounds(10,400,160,50);
		back.setCursor(cu2);
		back.addActionListener(this);
		contain.add(back);
		
		//CLEAR
		clear.setText("CLEAR");
		clear.setFont(new Font("Monaco",Font.BOLD,16));
		clear.setForeground(Color.BLUE);
		clear.setBackground(Color.CYAN);
		clear.setBounds(181,400,160,50);
		clear.setCursor(cu1);
		clear.addActionListener(this);
		contain.add(clear);
		
		//SEND
		send.setText("SEND");
		send.setFont(new Font("Monaco",Font.BOLD,16));
	    send.setForeground(Color.BLUE);
		send.setBackground(Color.CYAN);
		send.setBounds(353,400,160,50);
		send.setCursor(cu1);
		send.addActionListener(this);
		contain.add(send);
		
		//CLOSE
		close.setText("CLOSE");
		close.setFont(new Font("Monaco",Font.BOLD,16));
		close.setForeground(Color.BLUE);
		close.setBackground(Color.CYAN);
		close.setBounds(524,400,160,50);
		close.setCursor(cu2);
		close.addActionListener(this);
		contain.add(close);
		
		//JLABEL
		//LAB
		lab.setText("MESSAGE SENDER");
		lab.setBounds(200,100,300,100);
		lab.setFont(new Font("Monaco",Font.BOLD,30));
		contain.add(lab);
		
		//JTEXTAREA
		//TEXTS
        sender.setBounds(20,200,320,150); 
		sender.setBackground(Color.WHITE);
		sender.setForeground(Color.BLUE);
		sender.setFont(new Font("Monaco",Font.BOLD,16));
		contain.add(sender);
		
		receiver.setBounds(360,200,320,150); 
		receiver.setBackground(Color.WHITE);
		receiver.setForeground(Color.BLUE);
		receiver.setFont(new Font("Monaco",Font.BOLD,16));
		contain.add(receiver);
	}
	
	//FUNCTION TO IMPLENENT ACTIONLISTENER
	public void actionPerformed(ActionEvent ac)
	{
		try {
			if(ac.getSource()==close)
			{
				frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frames.dispose();
			}
			else if(ac.getSource()==back)
			{
				frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frames.dispose();
				new Setting();
			}
			else if(ac.getSource()==send)
			{	
				output.println(sender.getText());
				
			}
			else if(ac.getSource()==clear)
			{
				sender.setText("");
				receiver.setText("");
			}
		}catch(Exception ec) {
			System.out.println("\nTHERE IS AN EXCEPTION : "+ec);
		}
	}
	
	//MAIN FUNCTION
	/*public static void main(String args[])
	{
		
		new MessageClient(Integer.parseInt(args[0]));
	}*/
	
}
