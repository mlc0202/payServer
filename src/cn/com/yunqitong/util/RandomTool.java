package cn.com.yunqitong.util;

import java.util.Random;

/**
 * @项目名称：tems
 * @类名： RandomTool.java
 * @作者： 任龙
 * @创建日期： 2014-3-13 下午4:21:35
 * @版本： V1.0
 */

public class RandomTool {
	public static final int VALIDATECODELENGTH = 4 ;
	public static final int TOKENLENGTH = 32 ;
	
	/**
	 * @throws Exception
	 * @方法名称：main
	 * @作者： 任龙
	 * @创建日期： 2014-3-13 下午4:21:36
	 * @参数：@param args
	 */

	public static void main(String[] args) throws Exception {
//		for (int i = 0; i < 200; i++) {
//			System.out.println(getCharAndNumr(15));
//		}
		System.out.println(RandomTool.random(4));
	}
	
	public static String random(int n) {
        if (n < 1 || n > 10) {
            throw new IllegalArgumentException("cannot random " + n + " bit number");
        }
        Random ran = new Random();
        if (n == 1) {
            return String.valueOf(ran.nextInt(10));
        }
        int bitField = 0;
        char[] chs = new char[n];
        for (int i = 0; i < n; i++) {
            while(true) {
                int k = ran.nextInt(10);
                if( (bitField & (1 << k)) == 0) {
                    bitField |= 1 << k;
                    chs[i] = (char)(k + '0');
                    break;
                }
            }
        }
        return new String(chs);
    }

	/**
	 * 只想要大写的字母 可以使 int choice =65； 只想要小写的字母，就 int choice =97；
	 * 
	 * @param length
	 * @return
	 */
	public static String getCharAndNumr(int length) {
		int i_num = 0;
		int b_str = 0;
		int s_str = 0;

		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int num = random.nextInt(5) % 2;
			String charOrNum = "";
			if (num == 0) {
				charOrNum = "char";
			}
			if (num == 1) {
				charOrNum = "num";
			}
			if (num == 2) {
				charOrNum = "spe";
			}

			if ("char".equalsIgnoreCase(charOrNum)) // 字符串
			{
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
				if (choice == 65) {
					b_str++;
				} else {
					s_str++;
				}
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) // 数字
			{
				val += String.valueOf(random.nextInt(10));
				i_num++;
			} else if ("spe".equalsIgnoreCase(charOrNum)) // 特殊字符
			{
				int choice = 35;
				val += (char) (choice + random.nextInt(3));
			}
		}
		if (i_num == 0) {
			val += String.valueOf(random.nextInt(10));
		}
		if (b_str == 0) {
			val += (char) (65 + random.nextInt(26));
		}
		if (s_str == 0) {
			val += (char) (97 + random.nextInt(26));
		}
		return val;
	}

}
