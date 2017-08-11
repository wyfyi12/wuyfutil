package comwx;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class WXDoTag {
	public static JSONObject addtag(JSONObject tag,String token){
		String rs=null;
		try {
			String url="https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(tag.toString());
			System.out.println("创建标签:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject modtag(JSONObject tag,String token){
		String rs=null;
		try {
			String url="https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(tag.toString());
			System.out.println("更改标签:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject deltag(String tagid,String token){
		String rs=null;
		try {
			String url="https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token="+token+"&tagid="+tagid;
			HttpsUtil.getconnbyget(url);
			rs=HttpsUtil.getrsbyget();
			System.out.println("删除标签:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject gettaguser(String tagid,String token){
		String rs=null;
		try {
			String url="https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token="+token+"&tagid="+tagid;
			HttpsUtil.getconnbyget(url);
			rs=HttpsUtil.getrsbyget();
			System.out.println("获取标签成员:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject addtaguser(JSONObject tag,String token){
		String rs=null;
		try {
			String url="https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(tag.toString());
			System.out.println("创建标签成员:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject deltaguser(JSONObject tag,String token){
		String rs=null;
		try {
			String url="https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(tag.toString());
			System.out.println("删除标签成员:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject gettaguserlist(String token){
		String rs=null;
		try {
			String url="https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token="+token;
			HttpsUtil.getconnbyget(url);
			rs=HttpsUtil.getrsbyget();
			System.out.println("获取标签列表:"+rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
}
