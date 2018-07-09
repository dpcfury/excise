package org.dpc.cxf.ws.impl;

import java.util.Date;

import javax.jws.WebService;

import org.dpc.cxf.ws.HelloWorld;

@WebService(endpointInterface = "org.dpc.cxf.ws.HelloWorld", serviceName = "HelloWorldWs")
public class HelloWorldWs implements HelloWorld {

	@Override
	public String sayHi(String name) {
		// TODO Auto-generated method stub
		return name + " 您好" + "现在时间时:" + new Date();
	}

}
