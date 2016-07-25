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

//������ Ŭ���̾�Ʈ�� �������� �����͸� �о ledon�̶�� ���� ��ġ�ϴ� ���ڿ��� ������
//pi4j�� �̿��ؼ� gpio0�� �ɿ� ����� led�� Ű�� ledoff�� ������ ���� ���� �ϴ� ������
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
