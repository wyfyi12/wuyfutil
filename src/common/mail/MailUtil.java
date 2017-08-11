package common.mail;

import java.util.HashMap;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Store;

import common.json.DoJson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import oldmail.OldDoToken;
import oldmail.OldDoUser;
import oldmail.OldMailMod;

public class MailUtil {
	public static String poplogin(String userid,String password) throws Exception{
		String rs=null;
		Properties props = new Properties(); 
	     props.setProperty("mail.store.protocol", "pop3");       // 协议 
	     props.setProperty("mail.pop3.port", "110");             // 端口 
	     props.setProperty("mail.pop3.host", "pop.exmail.qq.com");    // pop3服务器 
	     Session session = Session.getInstance(props); 
	     Store store = session.getStore("pop3"); 
	     store.connect(userid, password);
	     store.close();
		return rs;
	}
	
	public static JSONArray swapdomain(String client_id,String client_secret,String newdomain){
		JSONArray rsja=new JSONArray();
		JSONObject token=OldDoToken.gettoken(client_id,client_secret);
		String tokens=token.getString("access_token");
		HashMap<String, String> tokenjob=new HashMap<String, String>();
		tokenjob.put("Authorization", "Bearer "+tokens);
		HashMap<String, String> user=new HashMap<String, String>();
		user.put("Ver", "0");
		JSONObject rs=OldDoUser.getuserlist(user, tokenjob);
		JSONArray userja=DoJson.getJSONArrayfromJSONObject(rs.toString(), "List");
		for(int i=0;i<userja.size();i++){
			JSONObject rsjob=new JSONObject();
			JSONObject userjob=userja.getJSONObject(i);
			String userid=userjob.getString("Alias");
			String alias=userid.split("@")[0];
			String newuserid=alias+"@"+newdomain;
			HashMap<String, String> moduser=new HashMap<>();
			moduser.put("Action", "3");
			moduser.put("Alias", userid);
			moduser.put("slave", newuserid);
			String addslavers=OldDoUser.moduser(moduser, tokenjob);
			System.out.println(i+"添加别名:"+newuserid+"rs:"+addslavers);
			if(addslavers.length()>2){
				rsjob.element(userid, addslavers);
			}
			String swaprs=OldMailMod.swapalias(userid, newuserid,tokens);
			System.out.println("切换主账号:"+userid+"rs:"+swaprs);
			if(swaprs.length()>2){
				rsjob.element(userid, swaprs);
			}else{
				rsjob.element(userid, "success");
			}
			rsja.add(rsjob);
		}
		return rsja;
	}
}
