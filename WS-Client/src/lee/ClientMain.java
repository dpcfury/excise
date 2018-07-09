package lee;

import org.dpc.cxf.ws.HelloWorld;
import org.dpc.cxf.ws.impl.HelloWorldWs;

public class ClientMain {

	public static void main(String[] args) {
		
		HelloWorldWs factory =new HelloWorldWs();
		
		HelloWorld hw =factory.getHelloWorldWsPort();
		
		System.out.println(hw.sayHi("dpc"));
	}
}
