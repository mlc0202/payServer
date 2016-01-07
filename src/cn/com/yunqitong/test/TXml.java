package cn.com.yunqitong.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.com.yunqitong.util.IDGenerator;
import cn.com.yunqitong.util.SentWxUtil;
import cn.com.yunqitong.util.WxUtil;

public class TXml {
	@Test
	public void testGetXml() {
		/*Document document = new Document();
		Element rootElement = new Element("xml");
		Attribute attribute = new Attribute("huli", "123");
		rootElement.setAttribute(attribute);
		document.setRootElement(rootElement);
		Element rootElement2 = document.getRootElement();
		Attribute attribute2 = rootElement.getAttribute("huli");
		String name = attribute2.getName();
		String value = attribute2.getValue();
		System.out.println(name);
		System.out.println(value);*/
		
		//Element rootElement=new Element("xml");
		//Document document=new Document(rootElement);
		/*System.out.println(IDGenerator.getId());
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddHHmmss");
		Date date=new Date();
		date.setMinutes(date.getMinutes()+10);
		String format = sf.format(date);
		System.out.println(format);
		
		String WxxmlBody="";*/
		/*Map<String,String> map=new HashMap<String, String>();
		map.put("return_code", "![CDATA[SUCCESS]]&gt;");
		map.put("return_msg", "&lt;![CDATA[OK]]&gt;");
		String rquestXmlString = SentWxUtil.getRquestXmlString(map);
		System.out.println(rquestXmlString);*/
		String aa="";
		
	}
}
