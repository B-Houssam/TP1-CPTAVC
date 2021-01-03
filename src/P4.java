import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port4_3 = 2004;
		int port4_5 = 2005;
		
		try {
			//int k = 10/0;
			ServerSocket s = new ServerSocket(port4_3);
			System.out.println("P4 is listening on port: " + port4_3 + "...");
			
     		Socket connection = s.accept();		
			
			ObjectInputStream in = new ObjectInputStream(connection.getInputStream());	
			
			int ss = (int) in.readObject(); // Par P3. 
			int pr = (int) in.readObject(); // Par P3. 
			System.out.println("P3 a envoye: " + ss + " et " + pr);
			
			//-------------------------------------------------//

			Socket c = new Socket("localhost",port4_5);
			System.out.println("Connection Accepted on port " + port4_5 + "...");
			
			ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
			
			System.out.println("Evoie de S= "+ss+", Pr= "+pr+" vers P5");
			out.writeObject(ss);	
			out.writeObject(pr);	
			
			//-------------------------------------------------//
			
			connection.close();	
			s.close();
			in.close();
			out.close();
			c.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: " + e.toString());
			ExceptionSave s = new ExceptionSave();
			s.save(e);

		}
	}

}
