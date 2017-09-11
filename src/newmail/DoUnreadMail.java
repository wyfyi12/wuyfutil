package newmail;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class DoUnreadMail {
	public static JSONObject getunreadmail(String token,JSONObject unread,String userid){
		String rs=null;
		try {
			String url="https://api.exmail.qq.com/cgi-bin/mail/newcount?access_token="+token+"&userid="+userid;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(unread.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
}
