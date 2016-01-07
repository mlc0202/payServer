package cn.com.yunqitong.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static final String defaultKey = "linkdata1234567890";

	public static boolean isEmpty(String str) {
		if (str != null && !str.equals(""))
			return false;
		return true;

	}
	/**
	 * 验证所输入字符串与是否与所输入规则匹配
	 * @return
	 */
	public static boolean VerifyRegexp(String verifiedStr ,String rule){
		Pattern pattern = Pattern.compile("");
		Matcher matcher = pattern.matcher("112");
		boolean b = matcher.matches();
		if(b!=true){
			return false;
		}
		return true;
	}
}
