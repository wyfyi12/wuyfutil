package oldmail;

import java.util.HashMap;

import common.http.HttpUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class OldDoParty {
	public static JSONObject modparty(HashMap<String, String> party,HashMap<String, String> token){
		String rs=null;
		try {
			String url="http://openapi.exmail.qq.com:12211/openapi/party/sync";
			HttpUtil.getconnbypost(url);
			HttpUtil.initConnection(token);
			rs=HttpUtil.getrsbypost(GetData.getData(party));
			System.out.println("同步部门信息:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject getparty(HashMap<String, String> party,HashMap<String, String> token){
		String rs=null;
		try {
			String url="http://openapi.exmail.qq.com:12211/openapi/party/list";
			HttpUtil.getconnbypost(url);
			HttpUtil.initConnection(token);
			rs=HttpUtil.getrsbypost(GetData.getData(party));
			System.out.println("获取部门信息:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
}
