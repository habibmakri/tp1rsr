package tp1;
import java.net.*;
import java.util.Scanner;
import java.io.*;

// Sans la comande flushe() le programme ne fonctionne pas

public class Client {
	static int port = 4500;
	static String server_name= "localhost";
	public static void main(String[] args) throws Exception{
		// La creation du client
		Scanner scan = new Scanner(System.in);
		Socket socket = new Socket(server_name,port);
		InputStreamReader reader = new InputStreamReader(socket.getInputStream());
		BufferedReader istream = new BufferedReader (reader);
		PrintWriter ostream = new PrintWriter(socket.getOutputStream());
		String chain1 = scan.nextLine();
		ostream.println(chain1);
		String chain2 = scan.nextLine();
		ostream.flush();;
		String line1 = istream.readLine();
		ostream.println(chain2);
		ostream.flush();
		System.out.println("je suis le client 1 : ");
		System.out.println("mon addresse Ip"+socket.getLocalAddress());
		System.out.println("L'addresse Ip de mon serveur"+socket.getInetAddress());
		System.out.println("les chaines envoyes s'ont:\n chaine1: "+chain1+" \n chaine2:"+chain2);
		
		
		String reponse = istream.readLine();
		System.out.println("la reponse du serveur: "+reponse);

		//System.out.println(line);
	}
}
