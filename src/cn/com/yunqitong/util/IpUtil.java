package cn.com.yunqitong.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
/**
* 获取客户端请求的ip  
* 项目名称：AuthorizationServer   
* 类名称：IpUtil   
* 创建人：huli   
* 创建时间：2015-12-22 上午11:52:22      
*
 */
public class IpUtil {
	public static String getIpAddr(HttpServletRequest request) {
		if (null == request) {
			return null;
		}

		String proxs[] = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR" };

		String ip = null;

		for (String prox : proxs) {
			ip = request.getHeader(prox);
			if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
				continue;
			} else {
				break;
			}
		}

		if (StringUtils.isBlank(ip)) {
			return request.getRemoteAddr();
		}

		return ip;
	}
}
