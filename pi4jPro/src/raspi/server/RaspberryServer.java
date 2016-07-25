package raspi.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class RaspberryServer {

	public static void main(String[] args) throws Exception {
		int port =8089;
		ServerSocket server = new ServerSocket(port);
		while(true){
			Socket client =server.accept();
			SocketAddress ip = client.getRemoteSocketAddress();
			Thread thread = new Thread(new LEDThread(client,ip));
			thread.start();
			if(client.isConnected()){
				System.out.println("\n connected! client:"+ip+"\n");
			}else{
				System.out.println("fail.....");
			}
		}
	}

}
