package cn.com.yunqitong.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class SentWxUtil {
	public  static String getRquestXmlString(Map map){
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("xml");
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Entry) it.next();
			Element author1 = root.addElement(entry.getKey()+"").addText(entry.getValue()+"");
		}
		String asXML = document.asXML();
		int i = asXML.indexOf(">");
		asXML=asXML.substring(i+2);
		return asXML;
	}
}
