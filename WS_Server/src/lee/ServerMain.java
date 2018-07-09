package lee;

import javax.xml.ws.Endpoint;

import org.dpc.cxf.ws.HelloWorld;
import org.dpc.cxf.ws.impl.HelloWorldWs;

public class ServerMain {

	public static void main(String[] args) {
		
		HelloWorld hw =new HelloWorldWs();
		Endpoint.publish("http://172.25.33.185:8081/crazyit", hw);
		System.out.println("Web Service 发布成功");
	}
}
