package org.gaibo.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.CharEncoding;

/**
 * MD5自动生成工具类
 * @author sangwenhao
 * @date 2017年8月30日
 */
public class MD5Utils {
	
	/**
	 * 获取MD5值
	 * @author sangwenhao
	 * @date 2017年8月24日 下午4:19:23
	 * @param data
	 * @return
	 */
	public static String getMD5HEX(String data){
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			//生成的md5摘要转换为小写16进制
			char[] encodeHex = encodeHex(digest.digest(data.getBytes(CharEncoding.UTF_8)), DIGITS_LOWER);
			String md5Hex = new String(encodeHex);
			System.out.println("转换后的MD5:"+md5Hex);
			return md5Hex;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null ;
	}
	
	 private static final char[] DIGITS_LOWER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	 private static final char[] DIGITS_UPPER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

	//字节转换为16进制字节
	protected static char[] encodeHex(byte[] data, char[] toDigits) {
        int l = data.length;
        char[] out = new char[l << 1];
        // two characters form the hex value.
        for (int i = 0, j = 0; i < l; i++) {
            out[j++] = toDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = toDigits[0x0F & data[i]];
        }
        return out;
    }

}
