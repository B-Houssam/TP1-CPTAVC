import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int port = 2002;
		int port1_3 = 2031;
		
		try {
			//int k = 10/0;
			
			/*
			 * envoie de N vers P2
			 */
			System.out.println("This is P1 ...");
			Socket c = new Socket("localhost",port);
			System.out.println("Connection Accepted on port " + port + "..."); //Déclaration nécessaires
			
			ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Entrer N: ");
			out.writeObject(sc.nextLine());		//Récupérer N 'entier'
			
			//-------------------------------------------------//
			
			ServerSocket s = new ServerSocket(port1_3);
			System.out.println("P1 is listening on port: " + port1_3 + "...");
			
     		Socket connection = s.accept();		
			
			ObjectInputStream in = new ObjectInputStream(connection.getInputStream());	
			
			String str = (String) in.readObject(); // Par P1. 
			System.out.println("P3 a envoye: " + str);
			
			//-------------------------------------------------//
			
			//Terminer les connections
			c.close();	
			out.close();
			s.close();
			in.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: " + e.toString());
			ExceptionSave s = new ExceptionSave();
			s.save(e);
		}
	}

}
