package cn.com.yunqitong.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.yunqitong.service.PayService;
import cn.com.yunqitong.util.HttpsUtil;
@RequestMapping(value="/pay")
@Controller
public class PayController {
	@Autowired
	private PayService payService;
	protected Logger log = Logger.getLogger(PayService.class);
	/**
	 * 微信支付方式发起支付请求
	 * @param request 请求数据
	 * @return响应数据
	 */
	@RequestMapping(value = "/wx")
	public String wxPay(HttpServletRequest request, HttpServletResponse response) {
		// 获取请求数据
		String reqText = HttpsUtil.getJsonFromRequest(request);
		log.info("request text pay by wx " + reqText);
		JSONObject resText = payService.getWxPayToken(reqText);
		HttpsUtil.sendAppMessage(resText.toString(), response);
		return null;
	}
	/**
	 * 支付宝支付
	 * @param request 接收数据
	 * @return 响应数据
	 */
	@RequestMapping(value = "/ali")
	public String aliPay(HttpServletRequest request, HttpServletResponse response) {
		// 获取请求数据
		String reqText = HttpsUtil.getJsonFromRequest(request);
		log.info("request text pay by ali " + reqText);
		JSONObject resText = payService.getAliPayToken(reqText);
		HttpsUtil.sendAppMessage(resText.toString(), response);
		return null;
	}
	
	/**
	 * 获取微信支付结果通知
	 * 		notify
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/result")
	public String payResult(HttpServletRequest request, HttpServletResponse response) {
		// 获取请求数据
		String reqText = HttpsUtil.getInfoFromRequest(request);
		log.info("request text from wx " + reqText);
		String res2WX=payService.getPayResult(reqText);
		HttpsUtil.sendAppMessage(res2WX, response);
		return null;
	}
	/**
	 * 接收支付宝支付结果通知
	 * @param request  接收数据
	 * @param response 响应数据
	 * @return
	 */
	@RequestMapping(value = "/aliResult")
	public String Test(HttpServletRequest request, HttpServletResponse response) {
		// 获取请求数据
		String reqText = HttpsUtil.getInfoFromRequest(request);
		log.info("request text from alipay " + reqText);
		String res2WX=payService.getAliPayResult(reqText);
		HttpsUtil.sendAppMessage(res2WX, response);
		return null;
	}
}
