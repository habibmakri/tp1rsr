package tp1Q3;
import java.net.*;
import java.util.Scanner;
import java.io.*;
// l'etulisation du methode flush() n'est pas necessaire
public class Client2 {
	static int port = 9000;
	static String server_name= "localhost";
	public static void main(String[] args) throws Exception{
		while(true) {
		
		Scanner scan = new Scanner(System.in);
		// La creation du client
		Socket socket = new Socket(server_name,port);
		ObjectOutputStream  in = new ObjectOutputStream (socket.getOutputStream());
		ObjectInputStream   listner = new ObjectInputStream  (socket.getInputStream());
		String chain1 = scan.nextLine();
		in.writeObject(chain1);
		//in.flush();
		listner.read();
		String chain2 = scan.nextLine();
		in.writeObject(chain2);
		in.flush();
		System.out.println("je suis le client 1 : ");
		System.out.println("mon addresse Ip"+socket.getLocalAddress());
		System.out.println("L'addresse Ip de mon serveur"+socket.getInetAddress());
		System.out.println("les chaines envoyes s'ont:\n chaine1: "+chain1+" \n chaine2:"+chain2);
		
		//socket.setSoTimeout(60000000);
		String ab,bc;
		ab = listner.readObject().toString();
		bc = listner.readObject().toString();
		System.out.println("la reponse du serveur: "+bc);
		}

	}
}
