package tp1Q2;
import java.net.*;
import java.io.*;
// l'etulisation du methode flush() n'est pas necessaire
public class Client2 {
	static int port = 4500;
	static String server_name= "localhost";
	public static void main(String[] args) throws Exception{
		// La creation du client
		String chain1 = "hello world";
		String chain2 = "world";
		System.out.println("je suis le client 1 : ");
		Socket socket = new Socket(server_name,port);
		System.out.println("mon addresse Ip"+socket.getLocalAddress());
		System.out.println("L'addresse Ip de mon serveur"+socket.getInetAddress());
		System.out.println("les chaines envoyes s'ont:\n chaine1: "+chain1+" \n chaine2:"+chain2);
		
		DataOutputStream data = new DataOutputStream(socket.getOutputStream());
		DataInputStream listner = new DataInputStream(socket.getInputStream());
		data.writeBytes(chain1);
		data.flush();
		listner.read();
		data.writeBytes(chain2);
		data.flush();
		byte[] ab;
		ab = listner.readAllBytes();
		String reponse = new String(ab);
		System.out.println("la reponse du serveur: "+reponse);


	}
}
