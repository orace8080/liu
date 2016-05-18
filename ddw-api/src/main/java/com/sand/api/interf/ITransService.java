package com.sand.api.interf;

import java.rmi.RemoteException;
import java.util.List;

import com.sand.api.dto.PageDTO;
import com.sand.api.dto.TransDTO;
import com.sand.api.param.Parameter;
import com.sand.api.security.Security;

public interface ITransService extends IService {

	/**
	 * 根据流水流水号查询一笔交易的详细信息
	 * 
	 * @param security
	 * @param transId
	 * @return
	 * @throws RemoteException
	 */
	@Deprecated
	public TransDTO getOne(Security security, String transId)
			throws RemoteException;

	/**
	 * 分页查询交易流水, 可设置多个条件, See {@link Parameter} or Document
	 * 
	 * 
	 * @param {@link Security}
	 * @param {@link Parameter}
	 * @return
	 * @throws RemoteException
	 */
	public PageDTO<TransDTO> getTransListByPage(Security security,
			Parameter parameter) throws RemoteException;

	/**
	 * 查询符合条件的所有交易流水, 适合报表导出等功能,
	 * 
	 * 注意： 此查询耗时严重, 请谨慎调用.
	 * 
	 * @param {@link Security}
	 * @param {@link Parameter}
	 * @return
	 * @throws RemoteException
	 */
	public List<TransDTO> getTransList(Security security, Parameter parameter)
			throws RemoteException;

}
