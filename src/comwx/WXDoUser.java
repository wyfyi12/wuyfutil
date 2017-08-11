package comwx;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class WXDoUser {
	public static String adduser(JSONObject user,String token){
		String rs = null;
		String url="https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token="+token;
		HttpsUtil.getconnbypost(url);
		rs=HttpsUtil.getrsbypost(user.toString());
		System.out.println(rs);
		rs="create user "+user.getString("userid")+" rs:"+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static String moduser(JSONObject user,String token){
		String rs = null;
		String url="https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token="+token;
		HttpsUtil.getconnbypost(url);
		rs=HttpsUtil.getrsbypost(user.toString());
		System.out.println(rs);
		rs="mod user "+user.getString("userid")+" rs:"+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static String deluser(String userid,String token){
		String rs = null;
		String url="https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token="+token+"&userid="+userid;
		HttpsUtil.getconnbyget(url);
		rs=HttpsUtil.getrsbyget();
		System.out.println(rs);
		rs="del user "+userid+" rs:"+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static JSONObject getuser(String userid,String token){
		String rs = null;
		JSONObject userinfo=null;
		String url="https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token="+token+"&userid="+userid;
		HttpsUtil.getconnbyget(url);
		rs=HttpsUtil.getrsbyget();
		//System.out.println("get user "+userid+" rs:"+DoJson.getJSONObjectfromString(rs).getString("errmsg"));
		userinfo=JSONObject.fromObject(rs);
		return userinfo;
	}
	
	public static JSONObject deluserlist(JSONObject user,String token){
		String rs = null;
		JSONObject userinfo=null;
		String url="https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token="+token;
		HttpsUtil.getconnbyget(url);
		rs=HttpsUtil.getrsbyget();
		System.out.println("delete userlist "+user.getString("useridlist")+" rs:"+DoJson.getJSONObjectfromString(rs).getString("errmsg"));
		userinfo=JSONObject.fromObject(rs);
		return userinfo;
	}
	
	public static JSONObject getpartyuser(String department_id,String fetch_child,String token){
		String rs = null;
		JSONObject userinfo=null;
		String url="https://qyapi.weixin.qq.com/cgi-bin/user/simplelist?access_token="+token+"&department_id="+department_id+"&fetch_child="+fetch_child;
		HttpsUtil.getconnbyget(url);
		rs=HttpsUtil.getrsbyget();
		System.out.println("get partyuser "+department_id+" rs:"+DoJson.getJSONObjectfromString(rs).getString("errmsg"));
		userinfo=JSONObject.fromObject(rs);
		return userinfo;
	}
	
	public static JSONObject getpartyuserinfo(String department_id,String fetch_child,String token){
		String rs = null;
		JSONObject userinfo=null;
		String url="https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token="+token+"&department_id="+department_id+"&fetch_child="+fetch_child;
		HttpsUtil.getconnbyget(url);
		rs=HttpsUtil.getrsbyget();
		System.out.println("get partyuser "+department_id+" rs:"+DoJson.getJSONObjectfromString(rs).getString("errmsg"));
		userinfo=JSONObject.fromObject(rs);
		return userinfo;
	}
}
