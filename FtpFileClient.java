
import java.io.*;
import java.net.*;
public class FtpFileClient {
private Socket s;
	public FtpFileClient(String host, int port, String fileName) {
	try {
		s = new Socket(host, port);
		sendFile(fileName);
	    }
        catch (Exception e) 
        {
	e.printStackTrace();
	}		
	}
	
	public void sendFile(String fileName){
            try{
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		FileInputStream fis = new FileInputStream(fileName);
		byte[] b = new byte[1024];
		
		while (fis.read(b) > 0) {
			dos.write(b);
		}
		dos.flush();
		fis.close();
		dos.close();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
	}	
	/*public static void main(String[] args) {
		FtpFileClient ffc = new FtpFileClient("localhost", 1980, "F:/Multimedia/video/simplevideo.mp4");
                System.out.println("File send");
        }*/
}