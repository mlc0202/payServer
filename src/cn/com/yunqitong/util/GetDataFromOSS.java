package cn.com.yunqitong.util;
/**
* 从OSS获取秘钥
* 项目名称：AuthorizationServer   
* 类名称：GetKeySecretFromOss   
* 创建人：huli   
* 创建时间：2015-12-15 下午8:22:30      
*
 */
public class GetDataFromOSS {
	/**
	 * 从OSS获取秘钥和key 
	 * @param hostid
	 * @return
	 * @throws Exception
	 */
	public static String getSecretAndKeyFromOss(String hostid) throws Exception{
		String requestJson = "{\"hostid\":\"" + hostid + "\"}";
		String restext = HttpsUtil.doPost(PropertyFactory.getProperty("OSSADDR")+"/authorization/getserverkey", requestJson);
		return restext;
	}
	public static String getDataFromOSS(String url,String reqjson) throws Exception{
		String restext = HttpsUtil.doPost(url, reqjson);
		return restext;
	}
}
