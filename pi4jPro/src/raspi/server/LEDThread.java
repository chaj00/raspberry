package raspi.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

//접속한 클라이언트가 보내오는 데이터를 읽어서 ledon이라는 값과 일치하는 문자열이 있으면
//pi4j를 이용해서 gpio0번 핀에 연결된 led를 키고 ledoff를 만나면 끄는 일을 하는 쓰레드
public class LEDThread implements Runnable {
	private Socket client;
	private SocketAddress ip;
	final GpioController controller = GpioFactory.getInstance();
	final GpioPinDigitalOutput ledpin = controller.provisionDigitalOutputPin(RaspiPin.GPIO_00,"led",PinState.LOW);
	public LEDThread(Socket client, SocketAddress ip) {
		this.client =client;
		this.ip = ip;
		
	}

	@Override
	public void run() {
		try {
			InputStream in=client.getInputStream();
			OutputStream out = client.getOutputStream();
			int ledBufSize =0;
			byte[] ledbuf = new byte[50];
			while((ledBufSize=in.read(ledbuf))!=-1){
				String ledData = new String(ledbuf,0,ledBufSize,"UTF-8");
				if(ledData.compareTo("ledon")==0){
					ledpin.high();
					System.out.println("ledon!");
				}
				if(ledData.compareTo("ledoff")==0){
					ledpin.low();
					System.out.println("ledoff");
				}
				out.write(ledbuf, 0, ledBufSize);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
		}
	}

}
