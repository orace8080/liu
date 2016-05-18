package com.sand.api.interf;

import java.rmi.Remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IService extends Remote {
	public Logger LOG = LoggerFactory.getLogger(IService.class);
}
