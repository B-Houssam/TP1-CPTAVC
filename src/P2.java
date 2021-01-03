import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port1_2 = 2002;
		int port2_3 = 2003;
		
		try {
			//int k = 10/0;
			ServerSocket s = new ServerSocket(port1_2);
			System.out.println("P2 is listening on port: " + port1_2 + "...");
			
     		Socket connection = s.accept();		
			
			ObjectInputStream in = new ObjectInputStream(connection.getInputStream());	
			
			String str = (String) in.readObject(); // Par P1. 
			System.out.println("P1 a envoye: " + str);
			
			//-------------------------------------------------//
			
			Socket c = new Socket("localhost",port2_3);
			System.out.println("Connection Accepted on port " + port2_3 + "...");
			
			ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Entrer M: ");
			out.writeObject(sc.nextLine());	
			out.writeObject(str);	
			
			//------------------------------------------------//
			
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
