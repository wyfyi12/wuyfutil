package comwx;

import common.http.HttpsUtil;

public class WXGetUserId {
	public static String getuserid(String token,String code){
		String rs=null;
		String url="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token="+token+"&code="+code;
		HttpsUtil.getconnbyget(url);
		rs=HttpsUtil.getrsbyget();
		return rs;
	}
}
