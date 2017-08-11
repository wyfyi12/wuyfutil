package comwx;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class WXDoParty {
	public static String createparty(String token,JSONObject partyjob){
		String rs=null;
		try{
			String url="https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(partyjob.toString());
			System.out.println("创建部门"+partyjob.getString("name")+",rs:"+rs);
		}catch(Exception e){
			e.printStackTrace();
		}
		rs="create party "+partyjob.getString("name")+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static String modparty(String token,JSONObject partyjob){
		String rs=null;
		try{
			String url="https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(partyjob.toString());
			System.out.println("更新部门"+partyjob.getString("name")+",rs:"+rs);
		}catch(Exception e){
			e.printStackTrace();
		}
		rs="mod party "+partyjob.getString("name")+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static String delparty(String token,String partyid){
		String rs=null;
		try{
			String url="https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token="+token+"&id="+partyid;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbyget();
			System.out.println("删除部门"+partyid+",rs:"+rs);
		}catch(Exception e){
			e.printStackTrace();
		}
		rs="delete party "+partyid+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static JSONObject getpartylist(String token,String partyid){
		String rs=null;
		try{
			String url="https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token="+token+"&id="+partyid;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbyget();
			System.out.println("获取部门列表"+partyid+",rs:"+rs);
		}catch(Exception e){
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
}
