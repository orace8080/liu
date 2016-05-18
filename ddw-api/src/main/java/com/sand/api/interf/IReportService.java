package com.sand.api.interf;

import com.sand.api.dto.PageDTO;
import com.sand.api.dto.TradExpandDTO;
import com.sand.api.dto.TradProjectDTO;
import com.sand.api.param.Parameter;
import com.sand.api.security.Security;

import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by Administrator on 2016/1/5.
 */
public interface IReportService  extends  IService{

    /**
     * 分页查询
     * @param security
     * @param parameter
     * @return
     */
    public PageDTO<TradExpandDTO> getListExpandByPage(Security security, Parameter parameter) throws RemoteException;

    public List<TradExpandDTO> getListExpand(Security security, Parameter parameter)throws RemoteException;

    public PageDTO<TradProjectDTO> getListPorjectByPage(Security security, Parameter parameter) throws RemoteException;

    public List<TradProjectDTO> getListProject(Security security, Parameter parameter) throws RemoteException;
}
