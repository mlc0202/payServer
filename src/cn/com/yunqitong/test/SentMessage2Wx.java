package cn.com.yunqitong.test;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

public class SentMessage2Wx {
	@Test
	public void t() {
		/*String url = PropertyFactory.getProperty("WXADDR");
		TOrderRecord record = new TOrderRecord();
		record.setBody("CA");
		record.setDetail("不知道");
		try {
			JAXBContext context = JAXBContext.newInstance(TOrderRecord.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(record, System.out);
			// HttpsUtil.doPostXml(url, xml);
		} catch (JAXBException e) {
			e.printStackTrace();
		}*/
	}

	@Test
	public void get() {
		SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
		parameters.put("appid", "3434");
		parameters.put("mch_id", "344534");
		parameters.put("body", "346ghgh34");
		parameters.put("nonce_str", "348934");
		parameters.put("out_trade_no", "34uii34");
		parameters.put("trade_type", "343rtrt4");
		parameters.put("notify_url", "34ere34");
		parameters.put("total_fee", "34erqewr34");
		
	}
}
