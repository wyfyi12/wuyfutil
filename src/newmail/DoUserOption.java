package newmail;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class DoUserOption {
	public static JSONObject getusertype(String token,JSONObject option){
		String rs=null;
		try {
			String url="https://api.exmail.qq.com/cgi-bin/useroption/get?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(option.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static String modusertype(String token,JSONObject option){
		String rs=null;
		try {
			String url="https://api.exmail.qq.com/cgi-bin/useroption/update?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(option.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		rs="update useroption "+option.getString("userid")+" "+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
}
