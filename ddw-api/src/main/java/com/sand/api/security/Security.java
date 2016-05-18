package com.sand.api.security;

/**
 * 安全对象, 每个客户端均有一个唯一的token值, 并请单独安全保存.<br>
 * 如发生数据泄露, 将由对应的token所属的应用方负责
 * <p>
 * 建议将当前对象为单例模式
 * {@code 
 * 	private static Security security = new Security("appid", "token");
 * 	public static Security getSecurity() 
 * 		return Security; 
 * 	}
 * }
 */
public class Security implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2340981273489121L;

	/**
	 * 客户端编号, 客户端根据自定义规则指定
	 */
	private String appid;
	/**
	 * 服务端颁发的token, 请向服务方索要, 注意保密
	 */
	private String token;
	
	/**
	 * 暂不使用
	 */
	private String version;

	public Security(String appid, String token) {
		this.appid = appid;
		this.token = token;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Security [appid=" + appid + ", token=" + token + ", version="
				+ version + "]";
	}
}
