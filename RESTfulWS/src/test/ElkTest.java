package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

public class ElkTest {

	
//  private static final String CLUSTER_NAME = "cluster_name";  
    public static final String CLUSTER_NAME = "globalhawk-es-cluster"; //ʵ������
    private static final String IP = "10.21.34.34";  
     //private static final String IP = "192.168.0.29";  
    private static final int PORT = 9300;  //�˿�
    //1.���ü�Ⱥ���ƣ�Ĭ����elasticsearch��������client.transport.sniffΪtrue��ʹ�ͻ�����̽������Ⱥ״̬���Ѽ�Ⱥ�е���������IP���뵽�ͻ�����  
    /* 
    //��ES1.6��Ч 
    private static Settings settings = ImmutableSettings 
            .settingsBuilder() 
            .put("cluster.name",CLUSTER_NAME) 
            .put("client.transport.sniff", true) 
            .build(); 
    */  
    //��ES2.0��Ч  
    private static Settings settings = ImmutableSettings  
            .settingsBuilder()  
            .put("cluster.name",CLUSTER_NAME)  
            .put("client.transport.sniff", true)  
            .build();  
    //����˽�ж���  
    private static TransportClient client;  
  
    //������ƴ���������TransportClient����  ES1.6�汾  
//    static {  
//        try {  
//            Class<?> clazz = Class.forName(TransportClient.class.getName());  
//            Constructor<?> constructor = clazz.getDeclaredConstructor(Settings.class);  
//            constructor.setAccessible(true);  
//            client = (TransportClient) constructor.newInstance(settings);  
//            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(IP), PORT));  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        }  
//    }  
  
    //ES2.0�汾  
    static {  
        try {  
            client = new TransportClient(settings)  
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(IP), PORT));  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        }  
    }  
  
    //ȡ��ʵ��  
    public static synchronized TransportClient getTransportClient(){  
        return client;  
    }  
  
    //Ϊ��Ⱥ����µĽڵ�  
    public static synchronized void addNode(String name){  
        try {  
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(name),9300));  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        }  
    }  
  
    //ɾ����Ⱥ�е�ĳ���ڵ�  
    public static synchronized void removeNode(String name){  
        try {  
            client.removeTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(name),9300));  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        }  
    }  
    public static void main(String args[]){
        String index="logstash-ehome-2016.04.21";    
        String type="apache_access"; 
        SearchResponse response=ElkTest.getTransportClient().prepareSearch(index)//����Ҫ��ѯ������(index)
        .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
        .setTypes(type)//����type, ����ڽ���������ʱ��ͬʱ������, ���߿���ʹ��head���߲鿴
        .setQuery(QueryBuilders.matchQuery("message", "request")) //������"message"��Ҫ��ѯ��field,"Accept"��Ҫ��ѯ������
        .setFrom(0)
        .setSize(10)
        .setExplain(true)
        .execute()
        .actionGet();
        for(SearchHit hit:response.getHits()){
            System.out.println(hit.getSourceAsString());
        }
    }  
}
