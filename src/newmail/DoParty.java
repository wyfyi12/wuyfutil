package newmail;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class DoParty {
	public static String createparty(String token,JSONObject partyjob){
		String rs=null;
		try{
			String url="https://api.exmail.qq.com/cgi-bin/department/create?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(partyjob.toString());
			System.out.println("add"+partyjob.getString("name")+",rs:"+rs);
		}catch(Exception e){
			e.printStackTrace();
		}
		rs="create party "+partyjob.getString("name")+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static String modparty(String token,JSONObject partyjob){
		String rs=null;
		try{
			String url="https://api.exmail.qq.com/cgi-bin/department/update?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(partyjob.toString());
			System.out.println("mod"+partyjob.getString("name")+",rs:"+rs);
		}catch(Exception e){
			e.printStackTrace();
		}
		rs="mod party "+partyjob.getString("name")+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static String delparty(String token,String partyid){
		String rs=null;
		try{
			String url="https://api.exmail.qq.com/cgi-bin/department/delete?access_token="+token+"&id="+partyid;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbyget();
			System.out.println("delete"+partyid+",rs:"+rs);
		}catch(Exception e){
			e.printStackTrace();
		}
		rs="delete party "+partyid+DoJson.getJSONObjectfromString(rs).getString("errmsg");
		return rs;
	}
	
	public static JSONObject getpartylist(String token,String partyid){
		String rs=null;
		try{
			String url="https://api.exmail.qq.com/cgi-bin/department/list?access_token="+token+"&id="+partyid;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbyget();
			//System.out.println("getpartylist¡¨"+partyid+",rs:"+rs);
		}catch(Exception e){
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject searchparty(String token,JSONObject partyjob){
		String rs=null;
		try{
			String url="https://api.exmail.qq.com/cgi-bin/department/search?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(partyjob.toString());
			System.out.println("search"+partyjob.getString("name")+",rs:"+rs);
		}catch(Exception e){
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
}
