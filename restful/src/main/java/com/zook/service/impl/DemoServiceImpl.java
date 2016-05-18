package com.zook.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zook.service.DemoService;

public class DemoServiceImpl extends UnicastRemoteObject implements DemoService {

	protected DemoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public String get() {
		// TODO Auto-generated method stub
		return "hello ";
	}

	
	
}
