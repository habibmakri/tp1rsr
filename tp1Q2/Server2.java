package tp1Q2;
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
		
		DataOutputStream data = new DataOutputStream(socket.getOutputStream());
		DataInputStream listner = new DataInputStream(socket.getInputStream());
		
		
		byte[] message1 = listner.readAllBytes();
		System.out.println("message 1 : "+message1.toString());
		data.write(0);
		byte[] message2 = listner.readAllBytes();
		System.out.println("message 2 : "+message2.toString());
		String reponse = "err";
		if(message1.toString().length()>message2.toString().length()) {
			
		if(message1.toString().contains(message2.toString())) {
			reponse = message1+" contient "+message2;
		}else{
			reponse = message1+" ne contient pas "+message2;
		}
		}else {
			if(message2.toString().contains(message1.toString())) {
				reponse = message2+" contient "+message1;
			}else {
				reponse = message2+" ne contient pas "+message1;
			}
		}
		data.writeBytes(reponse);
		
	}
		
	
	
	}
}
