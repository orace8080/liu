package com.elasticsearch;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {

	
	 public static DataFactory dataFactory = new DataFactory();
	    
	    private DataFactory(){
	        
	    }
	    
	    public DataFactory getInstance(){
	        return dataFactory;
	    }
	    
	    public static List<String> getInitJsonData(){
	        List<String> list = new ArrayList<String>();
	        String data1  = JsonUtil.obj2JsonData(new Medicine(1,"���� ��ð ����","�������Σ�������ð���� ��ͷʹ,���ȣ�������ʡ�"));
	        String data2  = JsonUtil.obj2JsonData(new Medicine(2,"��ð  ֹ���ǽ�","�������Σ���ðֹ���ǽ�,������ȣ�ֹ�Ȼ�̵��"));
	        String data3  = JsonUtil.obj2JsonData(new Medicine(3,"��ð�����","�������Σ�������ʹ��ͷʹ ,���ȡ�"));
	        String data4  = JsonUtil.obj2JsonData(new Medicine(4,"��ð  �齺��","�������Σ�������ð���� ��ͷʹ,���ȣ�������ʡ�"));
	        String data5  = JsonUtil.obj2JsonData(new Medicine(5,"�ʺ� ��ð ����","�������Σ�������ȣ�����ֹ��,������ȣ�ֹ�Ȼ�̵��"));
	        list.add(data1);
	        list.add(data2);
	        list.add(data3);
	        list.add(data4);
	        list.add(data5);
	        return list;
	    }
}
