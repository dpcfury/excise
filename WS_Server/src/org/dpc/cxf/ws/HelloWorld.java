package org.dpc.cxf.ws;

import java.util.List;

import javax.jws.WebService;

import org.dpc.cxf.domain.Cat;
import org.dpc.cxf.domain.User;

@WebService
public interface HelloWorld {

	
	public String  sayHi(String name);
	
//	List <Cat>getCatsByUser(User user);
}
