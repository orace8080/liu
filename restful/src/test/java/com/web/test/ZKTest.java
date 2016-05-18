package com.web.test;

import java.rmi.RemoteException;
import java.util.List;

import com.exception.LookupException;
import com.util.Parameter;
import com.util.Security;
import com.zook.api.ZKClientManager;
import com.zook.api.conts.ServiceConsts;
import com.zook.service.ITransService;

public class ZKTest {

	public static void main(String[] args) throws RemoteException {
		ZKClientManager zk=new ZKClientManager("127.0.0.1:2181","zookeeper");
		Parameter p=new Parameter();
		try {
			ITransService service=zk.lookup(ServiceConsts.TRANS);
			List<com.web.pojo.Demo> list=service.getTransList(new Security("",""),p);
			for(com.web.pojo.Demo de:list){
				System.out.println("hostname:"+de.getHostName()+",username:"+de.getUserName()+",userIP:"+de.getUserIP());
			}
		} catch (LookupException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
