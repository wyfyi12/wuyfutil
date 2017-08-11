package comwx;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class WXDoMessage {
	public static JSONObject sendmessage(JSONObject message,String token){
		String rs=null;
		try {
			String url="https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(message.toString());
			System.out.println("发送信息:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
}
