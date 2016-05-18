package com.zook.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.dao.BaseDao;
import com.util.Parameter;
import com.util.Security;
import com.web.pojo.Demo;
import com.zook.service.ITransService;



@Service("transService")
public class TransServiceImpl extends UnicastRemoteObject implements
		ITransService {
	@Autowired
	private BaseDao baseDao;
	private final Logger LOG = LoggerFactory.getLogger(TransServiceImpl.class);


	private static final long serialVersionUID = 1231123412343545L;

	public TransServiceImpl() throws RemoteException {
		super();
	}

	public String getName(String name) throws RemoteException{
		// TODO Auto-generated method stub
		return name+"world";
	}

	public List<Demo> getTransList(Security security, Parameter parameter) throws RemoteException {
		List<Demo> list=(List<Demo>) baseDao.selectList("TradExpandMapper.trad_expand_select", parameter);
		return list;
	}

	
}
