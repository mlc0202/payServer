package cn.com.yunqitong.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.yunqitong.util.HttpsUtil;
import cn.com.yunqitong.util.VersionUtil;

@Controller
public class VersionController {
	/**
	 * 获取服务版本信息
	 * @param request
	 * @param response
	 * @return 版本
	 */
	@RequestMapping("/version")
	public String getVersion(HttpServletRequest request,HttpServletResponse response){
		String current_version = VersionUtil.currentVersion;
		HttpsUtil.sendAppMessage(current_version, response);
		return null;
	}
}
