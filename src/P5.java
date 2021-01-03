import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class P5 {
	
	static long factorial(int n)
    {
		long factorial = 1;
		for(int i = 1; i <= n; ++i)
	    {
          factorial = factorial * i;
	    }
	  return factorial;
    }
	
	static void table(int n)
    {
		System.out.println("Table de multiplication: ");
		System.out.println(n+"*1: " + n*1);
		System.out.println(n+"*2: " + n*2);
		System.out.println(n+"*3: " + n*3);
		System.out.println(n+"*4: " + n*4);
		System.out.println(n+"*5: " + n*5);
		System.out.println(n+"*6: " + n*6);
		System.out.println(n+"*7: " + n*7);
		System.out.println(n+"*8: " + n*8);
		System.out.println(n+"*9: " + n*9);
		System.out.println(n+"*10: " + n*10);
    }
	
	static int divisorSum(int num)
    {
        int result = 0; 
       
        for (int i = 2; i <= Math.sqrt(num); i++) 
        { 
            if (num % i == 0) 
            { 
                if (i == (num / i)) 
                    result += i; 
                else
                    result += (i + num / i); 
            } 
        }
        return (result + 1); 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				int port5_4 = 2005;
				
				try {
					//int k = 10/0;
					ServerSocket s = new ServerSocket(port5_4);
					System.out.println("P5 is listening on port: " + port5_4 + "...");
					
		     		Socket connection = s.accept();		
					
					ObjectInputStream in = new ObjectInputStream(connection.getInputStream());	
					
					int ss = (int) in.readObject(); // Par P4. 
					int pr = (int) in.readObject(); // Par P4. 
					System.out.println("P4 a envoye: " + ss + " et " + pr);

					//-------------------------------------------------//
					
				    System.out.println("Fact(S) = " + factorial(ss));
				    System.out.println("Somme des diviseurs(Pr) = " + divisorSum(pr));
				    table(pr);

					//-------------------------------------------------//
					
					connection.close();	
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
