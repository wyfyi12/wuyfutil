package newmail;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class DoLogin {
	public static JSONObject getloginurl(String token,String userid){
		String rs=null;
		try {
		String url="https://api.exmail.qq.com/cgi-bin/service/get_login_url?access_token="+token+"&userid="+userid;	
		HttpsUtil.getconnbyget(url);
		rs=HttpsUtil.getrsbyget();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
}
