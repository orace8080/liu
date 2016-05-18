package com.zook.service;

import java.rmi.RemoteException;

import java.util.List;

import com.util.Parameter;
import com.util.Security;
import com.web.pojo.Demo;



public interface ITransService extends IService {

	public List<Demo> getTransList(Security security, Parameter parameter)
			throws RemoteException;
	

}
