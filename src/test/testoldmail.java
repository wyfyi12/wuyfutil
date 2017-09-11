package test;

import java.util.HashMap;

import common.json.DoJson;
import net.sf.json.JSONObject;
import oldmail.OldDoToken;
import oldmail.OldDoUser;
import oldmail.OldLogin;

public class testoldmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject token=OldDoToken.gettoken("sdshunjing","82cd01b53405b4ceb1cd73fab1fcefb");
		System.out.println(token.toString());
//		HashMap<String, String> user=new HashMap<>();
//		user.put("Alias", "test1@yzsmarts.xyz");
//		user.put("Password", "Nantu123");
//		user.put("Action", "3");
//		HashMap<String, String> tokent=new HashMap<>();
//		tokent.put("Authorization", "Bearer "+token.getString("access_token"));
//		String userinfo=OldDoUser.moduser(user,tokent);
//		System.out.println(userinfo);
//		HashMap<String, String> alias=new HashMap<>();
//		alias.put("Alias", "test1@yzsmarts.xyz");
//		String rs=OldLogin.getauthkey(alias, tokent);
//		System.out.println(rs);
//		alias.put("Agent", "njarti");
//		String url=OldLogin.getlogin(alias, DoJson.getJSONObjectfromString(rs).getString("auth_key"));
//		System.out.println(url);
	}
}
