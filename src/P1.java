import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int port = 2002;
		
		try {
			//int k = 10/0;
			System.out.println("This is P1 ...");
			Socket c = new Socket("localhost",port);
			System.out.println("Connection Accepted on port " + port + "...");
			
			ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Entrer N: ");
			out.writeObject(sc.nextLine());		
			
			c.close();
			out.close();		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: " + e.toString());
			ExceptionSave s = new ExceptionSave();
			s.save(e);
		}
	}

}
