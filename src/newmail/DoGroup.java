package newmail;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class DoGroup {
	public static String addgroup(String token,JSONObject group){
		String rs=null;
		try{
		String url="https://api.exmail.qq.com/cgi-bin/group/create?access_token="+token;
		HttpsUtil.getconnbypost(url);
		rs=HttpsUtil.getrsbypost(group.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		rs="create group "+group.getString("groupname")+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static String modgroup(String token,JSONObject group){
		String rs=null;
		try{
		String url="https://api.exmail.qq.com/cgi-bin/group/update?access_token="+token;
		HttpsUtil.getconnbypost(url);
		rs=HttpsUtil.getrsbypost(group.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		rs="update group "+group.getString("groupname")+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static String delgroup(String token,String groupid){
		String rs=null;
		try{
		String url="https://api.exmail.qq.com/cgi-bin/group/delete?access_token="+token+"&groupid="+groupid;
		HttpsUtil.getconnbyget(url);
		rs=HttpsUtil.getrsbyget();
		}catch(Exception e){
			e.printStackTrace();
		}
		rs="delete group "+groupid+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static JSONObject getgroup(String token,String groupid){
		String rs=null;
		try{
		String url="https://api.exmail.qq.com/cgi-bin/group/get?access_token="+token+"&groupid="+groupid;
		HttpsUtil.getconnbyget(url);
		rs=HttpsUtil.getrsbyget();
		}catch(Exception e){
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
}
