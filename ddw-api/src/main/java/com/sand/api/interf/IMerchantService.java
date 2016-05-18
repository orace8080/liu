package com.sand.api.interf;

import java.rmi.RemoteException;
import java.util.List;

import com.sand.api.dto.BillDTO;
import com.sand.api.dto.BillDetailDTO;
import com.sand.api.param.Parameter;
import com.sand.api.security.Security;

public interface IMerchantService extends IService {
	/**
	 * 获取商户指定时间范围的按日对账单汇总
	 * 
	 * @param security
	 * @param parameter
	 * @return
	 * @throws RemoteException
	 */
	public List<BillDTO> getBillListByDateRange(Security security,
			Parameter parameter) throws RemoteException;

	/**
	 * 获取商户指定日期的对账单明细
	 * 
	 * @param security
	 * @param parameter
	 * @return
	 * @throws RemoteException
	 */
	public List<BillDetailDTO> getBillDetailByDay(Security security,
			Parameter parameter) throws RemoteException;
	
}
