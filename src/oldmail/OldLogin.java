package oldmail;

import java.util.HashMap;

import common.http.HttpUtil;

public class OldLogin {
	public static String getauthkey(HashMap<String, String> alias,HashMap<String, String> token){
		String rs="";
		try {
			String url="http://openapi.exmail.qq.com:12211/openapi/mail/authkey";
			HttpUtil.getconnbypost(url);
			HttpUtil.initConnection(token);
			rs=HttpUtil.getrsbypost(GetData.getData(alias));
			System.out.println("获取成员Authkey:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static String getlogin(HashMap<String, String> alias,String Authkey){
		String url="https://exmail.qq.com/cgibin/login?fun=bizopenssologin&method=bizauth&agent="+alias.get("Agent")+"&user="+alias.get("Alias")+"&ticket="+Authkey;
		return url;
	}
}
