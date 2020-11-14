
import java.io.*;
import java.net.*;
public class FtpFileClient2 {
      private Socket s;
	public FtpFileClient2(String host, int port, String fileName) {
	try {
		s = new Socket(host, port);
		receivedFile(fileName);
	    }
        catch (Exception e) 
        {
	e.printStackTrace();
	}		
	}
	
	public void receivedFile(String fileName){
            try{
		/*DataInputStream dis = new DataInputStream(s.getInputStream());
		FileOutputStream fos = new FileOutputStream(fileName);
		byte[] b = new byte[1024];
		int len;
		while ((len=dis.read(b)) > 0) {
			fos.write(b,0,len);
		}
		
		fos.close();
		dis.close();*/
		DataInputStream dis=new DataInputStream(s.getInputStream());
		FileOutputStream fout=new FileOutputStream(fileName);
		int i;
		while((i=dis.read())>-1)
		{
			fout.write(i);
		}
		fout.flush();
		dis.close();
		fout.close();
		s.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
	}	
	/*public static void main(String[] args) {
		FtpFileClient2 ffc = new FtpFileClient2("localhost", 1990, "E:/music ftp/music_copy_video5454.mp4");
                System.out.println("File Received");
        }*/
}