package newmail;


import common.http.HttpsUtil;
import common.json.DoJson;

public class DoToken {
 public static String gettoken(String corpid,String corpsecret){
	 String rs=null;
	 try{
	 String url="https://api.exmail.qq.com/cgi-bin/gettoken?corpid="+corpid+"&corpsecret="+corpsecret;
	 HttpsUtil.getconnbyget(url);
	 rs=HttpsUtil.getrsbyget();
	 }catch(Exception e){
		 e.printStackTrace();
	 }
	 rs=DoJson.getJSONObjectfromString(rs).getString("access_token");
	 return rs;
 }
}
