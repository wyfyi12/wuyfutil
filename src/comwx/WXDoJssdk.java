package comwx;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import common.http.HttpsUtil;
import common.json.DoJson;

public class WXDoJssdk {
	 public static String getjsticket(String token){
		 String ticket="";
		 String url="https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token="+token;
		 HttpsUtil.getconnbyget(url);
		 String rs=HttpsUtil.getrsbyget();
		 if(rs.contains("ticket")){
		 ticket=DoJson.getJSONObjectfromString(rs).getString("ticket");}
		 else{
			 ticket=rs; 
		 }
		 return ticket;
	 }
	 
	 public static String getsig(String noncestr,String jsapi_ticket,String timestamp,String url){
		 String[] paramArr = new String[] { "jsapi_ticket=" + jsapi_ticket,
					"timestamp=" + timestamp, "noncestr=" + noncestr, "url=" + url };
			Arrays.sort(paramArr);
			// 将排序后的结果拼接成一个字符串
			String content = paramArr[0].concat("&"+paramArr[1]).concat("&"+paramArr[2])
					.concat("&"+paramArr[3]);
			String gensignature = null;
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-1");
				// 对拼接后的字符串进行 sha1 加密
				byte[] digest = md.digest(content.toString().getBytes());
				gensignature = byteToStr(digest);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			// 将 sha1 加密后的字符串与 signature 进行对比
			if (gensignature != null) {
				return gensignature;// 返回signature
			} else {
				return "false";
			}
	 }
	 
	 /**
		 * 将字节数组转换为十六进制字符串
		 *
		 * @param byteArray
		 * @return
		 */
		private static String byteToStr(byte[] byteArray) {
			String strDigest = "";
			for (int i = 0; i < byteArray.length; i++) {
				strDigest += byteToHexStr(byteArray[i]);
			}
			return strDigest;
		}

		/**
		 * 将字节转换为十六进制字符串
		 *
		 * @param mByte
		 * @return
		 */
		private static String byteToHexStr(byte mByte) {
			char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
					'B', 'C', 'D', 'E', 'F' };
			char[] tempArr = new char[2];
			tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
			tempArr[1] = Digit[mByte & 0X0F];
			String s = new String(tempArr);
			return s;
		}
}
