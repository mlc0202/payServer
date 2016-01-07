package cn.com.yunqitong.util;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xml.internal.security.utils.Base64;

public class CipherUtil {
	public static byte[] key = "qazwsxgiedcjmolp".getBytes();

	public static byte[] sipKey = { (byte) 0x6A, (byte) 0x2A, (byte) 0x19, (byte) 0xF4, (byte) 0x1E, (byte) 0xCA, (byte) 0x85, (byte) 0x4B, (byte) 0x03, (byte) 0xE6, (byte) 0x9F,
			(byte) 0x5B, (byte) 0xFA, (byte) 0x58, (byte) 0xEB, (byte) 0x42 };

	public static String encryptSipPwdWithRC4(String data) throws Exception {
		return Base64.encode(encryptWithRC4(sipKey, data.getBytes("utf-8")));
	}

	public static String decrypSipPwdtWithRC4(String base64data) throws Exception {
		return new String(decryptWithRC4(sipKey, Base64.decode(base64data)), "utf-8");
	}

	public static String encryptWithRC4(String data) throws Exception {
		return Base64.encode(encryptWithRC4(key, data.getBytes("utf-8")));
	}

	public static String decryptWithRC4(String base64data) throws Exception {
		return new String(decryptWithRC4(key, Base64.decode(base64data)), "utf-8");
	}

	public static String encryptWithRC4(String key, String data) throws Exception {
		return Base64.encode(encryptWithRC4(key.getBytes(), data.getBytes("utf-8")));
	}

	public static String decryptWithRC4(String key, String base64data) throws Exception {
		return new String(decryptWithRC4(key.getBytes(), Base64.decode(base64data)), "utf-8");
	}

	private static byte[] encryptWithRC4(byte[] key, byte[] data) throws Exception {
		Cipher c = Cipher.getInstance("RC4");
		SecretKey sk = new SecretKeySpec(key, "RC4");
		c.init(Cipher.ENCRYPT_MODE, sk);
		return c.doFinal(data);
	}

	private static byte[] decryptWithRC4(byte[] key, byte[] encdata) throws Exception {
		Cipher c = Cipher.getInstance("RC4");
		SecretKey sk = new SecretKeySpec(key, "RC4");
		c.init(Cipher.DECRYPT_MODE, sk);
		return c.doFinal(encdata);
	}

	public static String encryptWithAES(String data) throws Exception {
		return Base64.encode(encryptWithAES(key, data.getBytes("utf-8")));
	}

	public static String decryptWithAES(String base64data) throws Exception {
		return new String(decryptWithAES(key, Base64.decode(base64data)), "utf-8");
	}

	public static String encryptWithAES(String key, String data) throws Exception {
		return Base64.encode(encryptWithAES(key.getBytes(), data.getBytes("utf-8")));
	}

	public static String decryptWithAES(String key, String base64data) throws Exception {
		return new String(decryptWithAES(key.getBytes(), Base64.decode(base64data)), "utf-8");
	}

	private static byte[] encryptWithAES(byte[] key, byte[] plainText) {
		String strKey = new String(key);
		if (strKey.length() < 16) {
			strKey = strKey + "abcdefghijklmnop".substring(strKey.length());
			key = strKey.getBytes();
		} else if (strKey.length() > 16) {
			key = strKey.substring(0, 16).getBytes();
		}
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] decryptText = cipher.doFinal(plainText);
			return decryptText;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static byte[] decryptWithAES(byte[] key, byte[] cipherText) {
		String strKey = new String(key);
		if (strKey.length() < 16) {
			strKey = strKey + "abcdefghijklmnop".substring(strKey.length());
			key = strKey.getBytes();
		} else if (strKey.length() > 16) {
			key = strKey.substring(0, 16).getBytes();
		}
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] plainText = cipher.doFinal(cipherText);
			return plainText;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String encryptWithMD5(String content) {

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException nsae) {

		}
		md.update(content.getBytes());
		byte bytes[] = md.digest();
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String hexString = Integer.toHexString(bytes[i] & 0xff);
			buff.append(hexString.length() == 2 ? hexString : "0" + hexString);
		}
		return buff.toString();
	}

	public static String Mod30Bytelephone(String telephone) {
		String md5 = encryptWithMD5(telephone);
		BigInteger b = new BigInteger(md5, 16);
		BigInteger b3 = b.mod(new BigInteger("30"));
		return b3.toString();
	}

	public static String encryptWithSHA256(String content) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			byte[] plainText = content.getBytes("UTF-8");
			md.update(plainText);
		} catch (Exception nsae) {

		}
		byte bytes[] = md.digest();
		StringBuffer buff = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String hexString = Integer.toHexString(bytes[i] & 0xff);
			buff.append(hexString.length() == 2 ? hexString : "0" + hexString);
		}
		return buff.toString();
	}

	public static void main(String[] args) throws Exception {
		// System.out.println(key.length);
		// String plain =
		// "{\"ResultCode\":\"00005\",\"ResultMsg\":\"手机号码不存在\",\"telephone\":\"18901351383\",\"validatecode\":\"\"}";
		// System.out.println("plain lenth = " + plain.length());
		// String aes_enc = Base64.encode(encryptWithAES(key,
		// plain.getBytes()));
		// System.out.println("aes_enc = " + aes_enc);
		// System.out.println("aes_enc lenth = " + aes_enc.length());
		// String aes_plain = new String(decryptWithAES(key,
		// Base64.decode(aes_enc)));
		//
		// String e = "CR+1gmbWbeChyA==";
		// System.out.println(decrypSipPwdtWithRC4(e));

		// String enc =
		// "gdGV3ZWU3p5CY6KxP1+aZPIvA4j6DDRX5kfOYAwRaJPHfgA4xpStXeQfA45g8iHy1cGSx0R5Z\\/nxFPUo9deHSMQC\\/Bot+G8uvuHOHp8xz2g\\/0aX9wgjNHz4lZifbtc2dN6ybHq7cgexqhrMWdEhDHNo3lz7lmU5nT3oRclBfi\\/PwB\\/BcG+fU7cXcQAr09FXPJdV\\/4nFhSrBQIAm2Rp00Aw8Dc6tYgSsAwXLTQU87je+iyIWXvEDOiKy5sR9lI5JBQaKu3aaynbuwloSGOMgGbFYutxOLSOzextDmiijZuRoZw1wCn7a+jmY6tyTN2uBwavNWNVIY3PERiKtAW77Ncg==";
		// String key = "8jo550sH7AsH1PwWY76z8bG551pZ85p1";
		//
		// String scr = decryptWithAES(key,enc);
		// System.out.println(scr);

//		for (int i = 0; i < 20; i++) {
//			String str = RandomTool.getCharAndNumr(20);
//			System.out.println(Mod30Bytelephone(str));
//		}

		String str = "enc "+"65Nb10X9SCc2GmQ";
		
		String enc = CipherUtil.encryptSipPwdWithRC4(str);
		
		System.out.println("enc  "+enc);
		
		String dec = CipherUtil.decrypSipPwdtWithRC4(enc);
		
		String en1 = "en1"+"Xhvc3hiNPrmqgbTUJTo6";
		
		System.out.println(dec);
		
		System.out.println(CipherUtil.decrypSipPwdtWithRC4(en1));
		
		System.out.println(encryptWithSHA256("111111"));
		
	}

}
