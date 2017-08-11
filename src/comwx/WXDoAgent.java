package comwx;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class WXDoAgent {
	public static JSONObject getagent(String agentid,String token){
		String rs=null;
		try {
			String url="https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token="+token+"&agentid="+agentid;
			HttpsUtil.getconnbyget(url);
			rs=HttpsUtil.getrsbyget();
			System.out.println("获取应用:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject setagent(JSONObject agent,String token){
		String rs=null;
		try {
			String url="https://qyapi.weixin.qq.com/cgi-bin/agent/set?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(agent.toString());
			System.out.println("设置应用:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject getagentlist(String token){
		String rs=null;
		try {
			String url="https://qyapi.weixin.qq.com/cgi-bin/agent/list?access_token="+token;
			HttpsUtil.getconnbyget(url);
			rs=HttpsUtil.getrsbyget();
			System.out.println("获取应用列表:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
}
