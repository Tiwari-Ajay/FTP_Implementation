
import java.io.*;
import java.net.*;
import java.lang.Thread;
import java.lang.Math;
import javax.imageio.*;
import java.nio.*;
import java.awt.image.*;
public class FtpFileServer {
	private ServerSocket ss,ss2;
	 FtpFileServer(int port1,int port2) {
		try
		{
			//System.out.println(port1+" "+port2);
			ss = new ServerSocket(port1);
			ss2 = new ServerSocket(port2);
			run1();
		} 
         catch (Exception e)
		 {
			e.printStackTrace();
		}
	}
	
	public void run1(){
			try
              {
				Socket cs = ss.accept(); 
				Socket cs2 = ss2.accept(); 
                              				//here cs is stands for client socket which is received 
				sendFile(cs,cs2);             // by server socket
			}
            catch (Exception e) 
            {
	          e.printStackTrace();
            }
	}

	private void sendFile(Socket cs,Socket cs2) {
            try{
		DataInputStream dis = new DataInputStream(cs.getInputStream());
		DataOutputStream dos = new DataOutputStream(cs2.getOutputStream());
		//FileOutputStream fos = new FileOutputStream("e:/DAACOPY.pdf");
		byte[] b = new byte[1024];  //here b is acts as buffer
                int len;
                 while((len = dis.read(b)) > 0)
					 dos.write(b);
				 dos.flush();
                 // fos.write(b, 0, len);
		System.out.println("hii ji");
		dos.close();
		dis.close();
	  /* DataInputStream dis = new DataInputStream(cs.getInputStream());  //final program
		FileOutputStream fos = new FileOutputStream("e:/DAACOPYmovie.mkv");
		int i;
		while((i=dis.read())>-1)
			fos.write(i);
		fos.flush();
		fos.close();
		dis.close();
		cs.close();*/
		
			
	}  
			catch(Exception e)
            {
               System.out.println(e);
            }
	}
	
/*public static void main(String[] args) {
		FtpFileServer fs = new FtpFileServer(1980,1990);
		fs.start();
        
	}*/

}