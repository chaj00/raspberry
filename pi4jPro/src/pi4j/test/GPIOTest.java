package pi4j.test;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class GPIOTest  {
	public static void main(String[] args) throws InterruptedException{
		//GPIO�� ������ �� �ִ� Ŭ������ ����
		GpioController controller = GpioFactory.getInstance();
		System.out.println("start");
		
		//����� GPIO���� ����
		//pin�� ���� ���� - led��  high(����) low(����)
		GpioPinDigitalOutput pin1 = 
							controller.provisionDigitalOutputPin(RaspiPin.GPIO_00,   //pi4j�� 0���� raspberry�� 17��
																"led01",
																PinState.HIGH);
		
		GpioPinDigitalOutput pin2 = 
				controller.provisionDigitalOutputPin(RaspiPin.GPIO_02,   //pi4j�� 2���� raspberry�� 27��
													"led02",
													PinState.LOW);
		
		Thread.sleep(500); //delay�� ����
		
		pin1.low(); //pin1 led off
		pin2.high(); //pin2 led on
		
		int count = 0;
		
		while(true){
			System.out.println("on...off...start");
			pin1.toggle();
			pin2.toggle();
			System.out.println("on");
			Thread.sleep(500);
			pin1.toggle();
			pin2.toggle();
			System.out.println("off");
			Thread.sleep(500);
			count++;
			if(count>5){
				System.out.println("end");
				pin1.low();
				pin2.low();
				controller.shutdown();
				break;
			}
		}
	
				
	}

}
