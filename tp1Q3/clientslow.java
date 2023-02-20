package tp1Q3;
import java.net.*;
import java.io.*;
// l'etulisation du methode flush() n'est pas necessaire
public class clientslow {
	static int port = 9000;
	static String server_name= "localhost";
	public static void main(String[] args) throws Exception{
		while(true) {
		
		
		// La creation du client
		String chain1 = "hi another client";
		String chain2 = "hi";
		System.out.println("je suis le client 1 : ");
		Socket socket = new Socket(server_name,port);
		System.out.println("mon addresse Ip"+socket.getLocalAddress());
		System.out.println("L'addresse Ip de mon serveur"+socket.getInetAddress());
		System.out.println("les chaines envoyes s'ont:\n chaine1: "+chain1+" \n chaine2:"+chain2);
		
		ObjectOutputStream  in = new ObjectOutputStream (socket.getOutputStream());
		ObjectInputStream   listner = new ObjectInputStream  (socket.getInputStream());
		//socket.setSoTimeout(60000000);
		in.writeObject(chain1);
		//in.flush();
		listner.read();
		in.writeObject(chain2);
		in.flush();
		String ab,bc;
		ab = listner.readObject().toString();
		bc = listner.readObject().toString();
		System.out.println("la reponse du serveur: "+bc);
		}

	}
}
