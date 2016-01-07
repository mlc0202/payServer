package cn.com.yunqitong.util;

import net.sf.json.JSONObject;

public class JsonUtil {
	/**
	 * 将json字符串转为JSONObject对象
	 * @param 被转换的json字符串
	 * @return 转换结果JSONObject
	 */
	public static JSONObject getJsonObject(String str){
		JSONObject jSONObject= null;
		try{
			jSONObject = JSONObject.fromObject(str);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return jSONObject;
	}
	/**
	 * 将对象信息转为json格式
	 * @param object 被转换对象
	 * @return json字符串
	 */
	public static String getJsonFromObject(Object object){
		JSONObject jsonObject = JSONObject.fromObject(object);
		return jsonObject.toString();
	}
}
