package test;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class UserInfoClient {

	public static final String BASE_URL="http://10.21.34.34:9300/";
	
	public static final String PATH_NAME="/helpFunc/custbirth/custBirthDetailQuery.jsp?pageIndex=3&birth_sdate=2016-04-01&birth_edate=2016-04-30";
	public static final String PATH_AGE="/UserInfoService/age";
	
	public static void main(String[] args) {
		String name="tom";
		int age=25;
		ClientConfig config=new DefaultClientConfig();
		Client client=Client.create(config);
		WebResource resource=client.resource(BASE_URL);
		WebResource nameResource=resource.path(PATH_NAME);
		System.out.println("Client Response \n"	+ getClientResponse(nameResource));
				System.out.println("Response \n" + getResponse(nameResource) + "\n\n");
//				 
//				WebResource ageResource = resource.path("rest").path(PATH_AGE + age);
//				System.out.println("Client Response \n"+ getClientResponse(ageResource));
//				System.out.println("Response \n" + getResponse(ageResource));
		
	}
	/**
	* ���ؿͻ�������
	* ���磺
	* GET http://localhost:8080/RESTfulWS/rest/UserInfoService/name/Pavithra 
	* ����������״̬��200 OK����
	*
	* @param service
	* @return
	*/
	private static String getClientResponse(WebResource resource) {
	return resource.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}
	/**
	* ����������XML
	* ���磺<User><Name>Pavithra</Name></User> 
	* 
	* @param service
	* @return
	*/
	private static String getResponse(WebResource resource) {
	return resource.accept(MediaType.TEXT_XML).get(String.class);
	}
}
