//package FilePackage;

//HEADER FILES
import java.net.*;
import java.io.*;
import java.util.Scanner;
class caster extends Thread {
	BufferedReader input;
	PrintStream output;
	caster(BufferedReader in, PrintStream out) {
		input = in;
		output = out;
	}
	public void run() {
		while(true) {
			try{
			String message = input.readLine();
			output.println(message);
			} catch (Exception e) {
				//
			}
		}
	}
}
//CLASS MESSAGESERVER
public class MessageServer {

	//REFERENCE DECLARATION
	private ServerSocket ss1,ss2;
	private Socket as,as2;
	private PrintStream output,output2;
	private BufferedReader input,input2;
	private Scanner scan=new Scanner(System.in);


	//METHOD TO RUN
	void run1(int port1,int port2){
	    try{
	        ss1=new ServerSocket(port1);
			ss2=new ServerSocket(port2);
	        as=ss1.accept();
			as2=ss2.accept();
	        output=new PrintStream(as.getOutputStream());
	        input=new BufferedReader(new InputStreamReader(as.getInputStream()));
	        output2=new PrintStream(as2.getOutputStream());
	        input2=new BufferedReader(new InputStreamReader(as2.getInputStream()));
			String message="";
			caster one = new caster(input, output2);
			caster two = new caster(input2, output);
			one.start();
			two.start();
	        /*while(!message.equals("exit"))
	        {
	            message=input.readLine();
	            //System.out.println("client :  " + message);
	           // String reply=scan.nextLine();
	           // output.println(reply);
			   output2.println(message);
			   message=input2.readLine();
			   output.println(message);

	        }*/

	    }catch(Exception e)
	    {
	    System.out.println(e);
	    }

	}

	//MAIN METHOD
	/*public static void main(String args[])
	{
		MessageServer server= new MessageServer();
	    server.run1();
	}*/

}
