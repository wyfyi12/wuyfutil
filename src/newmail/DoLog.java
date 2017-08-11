package newmail;

import common.http.HttpsUtil;
import common.json.DoJson;
import net.sf.json.JSONObject;

public class DoLog {
	public static JSONObject getmailstatus(String token,JSONObject mail){
		String rs=null;
		try {
			String url="https://api.exmail.qq.com/cgi-bin/log/mailstatus?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(mail.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject getmail(String token,JSONObject mail){
		String rs=null;
		try {
			String url="https://api.exmail.qq.com/cgi-bin/log/mail?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(mail.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject getlogin(String token,JSONObject mail){
		String rs=null;
		try {
			String url="https://api.exmail.qq.com/cgi-bin/log/login?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(mail.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject getbatchjob(String token,JSONObject mail){
		String rs=null;
		try {
			String url="https://api.exmail.qq.com/cgi-bin/log/batchjob?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(mail.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
	
	public static JSONObject getoperation(String token,JSONObject mail){
		String rs=null;
		try {
			String url="https://api.exmail.qq.com/cgi-bin/log/operation?access_token="+token;
			HttpsUtil.getconnbypost(url);
			rs=HttpsUtil.getrsbypost(mail.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DoJson.getJSONObjectfromString(rs);
	}
}
