package pi4j.test;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class GPIOTest  {
	public static void main(String[] args) throws InterruptedException{
		//GPIO를 제어할 수 있는 클래스를 생성
		GpioController controller = GpioFactory.getInstance();
		System.out.println("start");
		
		//사용할 GPIO핀을 정의
		//pin의 상태 제어 - led는  high(껴짐) low(꺼짐)
		GpioPinDigitalOutput pin1 = 
							controller.provisionDigitalOutputPin(RaspiPin.GPIO_00,   //pi4j의 0번은 raspberry의 17번
																"led01",
																PinState.HIGH);
		
		GpioPinDigitalOutput pin2 = 
				controller.provisionDigitalOutputPin(RaspiPin.GPIO_02,   //pi4j의 2번은 raspberry의 27번
													"led02",
													PinState.LOW);
		
		Thread.sleep(500); //delay와 동일
		
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
