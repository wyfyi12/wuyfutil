package oldmail;

import java.util.HashMap;

import common.http.HttpUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class OldDoUser {
	public static JSONObject getuser(HashMap<String, String> user,HashMap<String, String> token){
		String rs=null;
		try {
			String url="http://openapi.exmail.qq.com:12211/openapi/user/get";
			HttpUtil.getconnbypost(url);
			HttpUtil.initConnection(token);
			rs=HttpUtil.getrsbypost(GetData.getData(user));
			System.out.println("获取成员信息:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static String moduser(HashMap<String, String> user,HashMap<String, String> token){
		String rs=null;
		try {
			String url="http://openapi.exmail.qq.com:12211/openapi/user/sync";
			HttpUtil.getconnbypost(url);
			HttpUtil.initConnection(token);
			rs=HttpUtil.getrsbypost(GetData.getData(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public static JSONObject getuserlist(HashMap<String, String> user,HashMap<String, String> token){
		String rs=null;
		try {
			String url="http://openapi.exmail.qq.com:12211/openapi/user/list";
			HttpUtil.getconnbypost(url);
			HttpUtil.initConnection(token);
			rs=HttpUtil.getrsbypost(GetData.getData(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject swapalias(HashMap<String, String> user,HashMap<String, String> token){
		String rs=null;
		try {
			String url="http://openapi.exmail.qq.com:12211/openapi/user/swapalias";
			HttpUtil.getconnbypost(url);
			HttpUtil.initConnection(token);
			rs=HttpUtil.getrsbypost(GetData.getData(user));
			System.out.println("更换成员主账号:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
}
