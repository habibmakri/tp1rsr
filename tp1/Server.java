package tp1;
import java.net.*;
import java.io.*;
//path : C:\Users\habibo\eclipse-workspace\System Reapartis\src\tp1
public class Server {
	static int port = 4500;
	static int cpt = 1;
	public static void main(String[] args) throws Exception{
	// La creation du serveur
		ServerSocket Server_socket = new ServerSocket(port);
		while(true){
		System.out.println("en attend des client");
		Socket socket = Server_socket.accept(); 
		System.out.println("client "+cpt+" connect�");cpt++;
		System.out.println("adresse client"+socket.getRemoteSocketAddress());
		
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		BufferedReader istream = new BufferedReader (reader);
		PrintWriter ostream = new PrintWriter(socket.getOutputStream());
		String message1 = istream.readLine();
		System.out.println("message 1 : "+message1);
		ostream.println(0);
		ostream.flush();
		String message2 = istream.readLine();
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
		ostream.println(reponse);
		ostream.flush();
	}
		
	
	
	}
}
