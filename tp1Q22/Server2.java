package tp1Q22;
import java.net.*;
import java.io.*;
//path : C:\Users\habibo\eclipse-workspace\System Reapartis\src\tp1
public class Server2 {
	static int port = 4500;
	static int cpt = 1;
	public static void main(String[] args) throws Exception{
	// La creation du serveur
		ServerSocket Server_socket = new ServerSocket(port);
		while(true){
		System.out.println("en attend des client");
		Socket socket = Server_socket.accept(); 
		System.out.println("client "+cpt+" connecté");cpt++;
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
		in.writeObject(reponse);
		
	}
		
	
	
	}
}
