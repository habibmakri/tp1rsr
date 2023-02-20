package tp1Q3;
import java.net.*;
import java.io.*;
//path : C:\Users\habibo\eclipse-workspace\System Reapartis\src\tp1
// serveur multi thread
public class Server2 implements Runnable {
	
	private Socket socket;
	private int nb;
	public Server2(Socket socket, int nb)
	{
		this.socket = socket;
		this.nb     = nb;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	try {
		System.out.println("adresse client"+socket.getRemoteSocketAddress());
		
		ObjectOutputStream  in = new ObjectOutputStream (socket.getOutputStream());
		ObjectInputStream   listner = new ObjectInputStream  (socket.getInputStream());
		
		
		String message1 = listner.readObject().toString();
		System.out.println("message 1 : "+message1);
		in.writeObject("11");
		String message2 = listner.readObject().toString();
		System.out.println("message 2 : "+message2);
		String reponse = "err";
		if(message1.length()>message2.length()) {
			
		if(message1.contains(message2)) {
			reponse = message1+" contient "+message2;
		}else{
			reponse = message1+" ne contient pas "+message2;
		}
		}else {
			if(message2.contains(message1)) {
				reponse = message2+" contient "+message1;
			}else {
				reponse = message2+" ne contient pas "+message1;
			}
		}
		nb--;
		in.writeObject(reponse);
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	


	
}
