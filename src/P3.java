import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int port3_2 = 2003;
		int port3_4 = 2004;
		int port3_1 = 2031;
		
		try {
			//int k = 10/0;
			
			/*
			 * réception depuis P2
			 */
			ServerSocket s = new ServerSocket(port3_2);
			System.out.println("P3 is listening on port: " + port3_2 + "...");
			
     		Socket connection = s.accept();		
			
			ObjectInputStream in = new ObjectInputStream(connection.getInputStream());	
			
			String M = (String) in.readObject(); // Par P2. 
			String N = (String) in.readObject(); // Par P2. 
			System.out.println("P2 a envoye: " + M + " et " + N);
			
			
			//-------------------------------------------------//
			
			int ss = Integer.parseInt(N) + Integer.parseInt(M);
			
			int pr = 1;
			boolean flag = false;
			
			for (int j = 1; j <= ss; j++) {
				for (int i = 2; i <= j / 2; ++i) {
				      if (j % i == 0) {
				        flag = true;
				        break;
				      }
				    }
				if (!flag) {
					pr = pr*j;
				}
				flag = false;
			}
			
			//-------------------------------------------------//
			
			/*
			 * Envoie vers P4
			 */
			
			Socket c = new Socket("localhost",port3_4);
			System.out.println("Connection Accepted on port " + port3_4 + "...");
			
			ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
			
			System.out.println("Evoie de S= "+ss+", Pr= "+pr+" vers P5");
			out.writeObject(ss);	
			out.writeObject(pr);	
			
			/*
			 * Envoie vers P1
			 */
			
			Socket cc = new Socket("localhost",port3_1);
			System.out.println("Connection Accepted on port " + port3_1 + "...");
			
			ObjectOutputStream outt = new ObjectOutputStream(cc.getOutputStream());
				
			outt.writeObject("P3 dit a P1 ...");	
			
			//------------------------------------------------//
			
			connection.close();	
			s.close();
			in.close();
			out.close();
			c.close();
			cc.close();
			outt.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: " + e.toString());
			ExceptionSave s = new ExceptionSave();
			s.save(e);
		}
	}

}
