## 数据仓库接口文档说明书 ##


### 1、使用方法(示例代码) ###

	public static void main(String[] args) throws Exception {

		// zookeeper集群地址, 多个按","分隔
		String zkHosts = "192.168.32.152:2181";
	
		// 接口客户端管理对象, 保证单例, 全局唯一
		// 两个参数, 第一个参数为zookeeper集群地址, 第二个参数为数据仓库的app名称, 测试阶段统一为ddw
		ZKClientManager clientManager = new ZKClientManager(zkHosts, "ddw");
	
		// 从命名空间中获取一个远程接口引用
		ITransService service = clientManager.lookup();
	
		// 如同调用本地方法一样调用远程服务, 获取返回结果
		PageDTO<TransDTO> result = service.getTransList(new Security(),
				new Parameter() {
					private static final long serialVersionUID = 1L;
					{
						setMid("100310054115455");
						setStartDate("20150103");
						setEndDate("20150109");
					}
				});
	}
###  2、相关依赖 ###
其中涉及多个jar包，两个核心依赖包为ddw-api.jar和zookeeper.jar。  
接口采用maven管理依赖关系，在项目pom中配置如下，即可：

	<dependency>
		<groupId>com.sand</groupId>
		<artifactId>ddw-api</artifactId>
		<version>x.x.x</version>
	</dependency>
	<dependency>
		<groupId>org.apache.zookeeper</groupId>
		<artifactId>zookeeper</artifactId>
		<version>3.5.1-alpha</version>
	</dependency>

**注：因ddw-api.jar只包含在公司仓库中，还需增加仓库地址**

	<repositories>
		<repository>
			<id>sand</id>
			<name>sand</name>
			<url>http://192.168.32.152:8081/nexus/content/groups/public/</url>
		</repository>
	</repositories>

### 3、注意事项 ###
无