package com.web.test;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.exception.LookupException;
import com.web.test.pojo.Person;
import com.zook.api.ZKClientManager;
import com.zook.api.conts.ServiceConsts;
import com.zook.service.ITransService;

public class Demo {
	
	public static void main(String[] args) throws RemoteException {
		ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring-task.xml"});
//		ZKClientManager zk=new ZKClientManager("127.0.0.1:2181","zookeeper");
//		
//		try {
//			ITransService service=zk.lookup(ServiceConsts.TRANS);
//			
//			System.out.println(service.getName("hello"));
//		} catch (LookupException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
